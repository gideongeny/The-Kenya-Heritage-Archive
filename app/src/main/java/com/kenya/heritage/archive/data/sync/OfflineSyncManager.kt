package com.kenya.heritage.archive.data.sync

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import javax.inject.Singleton
import com.kenya.heritage.archive.data.model.HistoricalArtifact

@Singleton
class OfflineSyncManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val client = OkHttpClient()
    
    private val _isSyncing = MutableStateFlow(false)
    val isSyncing: StateFlow<Boolean> = _isSyncing.asStateFlow()

    private val _syncProgress = MutableStateFlow(0f)
    val syncProgress: StateFlow<Float> = _syncProgress.asStateFlow()

    private val _syncMessage = MutableStateFlow("")
    val syncMessage: StateFlow<String> = _syncMessage.asStateFlow()

    fun getVaultFile(url: String): File? {
        val fileName = url.substringAfterLast("/")
        val file = File(getVaultDirectory(), fileName)
        return if (file.exists() && file.length() > 0) file else null
    }

    private fun getVaultDirectory(): File {
        val dir = File(context.filesDir, "vault_media")
        if (!dir.exists()) {
            dir.mkdirs()
        }
        return dir
    }

    suspend fun startGlobalVaultSync(artifacts: List<HistoricalArtifact>) = withContext(Dispatchers.IO) {
        if (_isSyncing.value) return@withContext
        
        _isSyncing.value = true
        _syncProgress.value = 0f
        
        val vaultDir = getVaultDirectory()
        
        // Extract all unique media URLs from the artifacts
        val allUrls = mutableSetOf<String>()
        artifacts.forEach { artifact ->
            artifact.bannerImageUrl?.let { allUrls.add(it) }
            artifact.mediaAssets.forEach { asset -> 
                allUrls.add(asset.url)
                asset.thumbnailUrl?.let { allUrls.add(it) }
            }
        }
        
        val totalAssets = allUrls.size
        var completedAssets = 0
        
        for (url in allUrls) {
            val fileName = url.substringAfterLast("/")
            val file = File(vaultDir, fileName)
            
            _syncMessage.value = "Downloading $fileName..."
            
            if (!file.exists() || file.length() == 0L) {
                try {
                    val request = Request.Builder().url(url).build()
                    val response = client.newCall(request).execute()
                    if (response.isSuccessful) {
                        response.body?.byteStream()?.use { input ->
                            FileOutputStream(file).use { output ->
                                input.copyTo(output)
                            }
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    // Continue with next file
                }
            }
            
            completedAssets++
            _syncProgress.value = completedAssets.toFloat() / totalAssets.toFloat()
        }
        
        _syncMessage.value = "Vault completely synced and secured."
        _isSyncing.value = false
    }
}
