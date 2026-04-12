package com.kenya.heritage.archive.data.util

import android.content.Context
import java.io.File

/**
 * Resolves GitHub raw URLs for images and videos hosted in the repository.
 * Updated Phase 4: Acts as an offline-first proxy. If the asset exists in the
 * local Vault cache, returns the local file:// URI instead of the network URL.
 * Base URL: https://raw.githubusercontent.com/gideongeny/The-Kenya-Heritage-Archive/main/
 */
object GitHubAssetResolver {
    private const val BASE = "https://raw.githubusercontent.com/gideongeny/The-Kenya-Heritage-Archive/main"

    /**
     * Phase 4: Check if a remote URL is cached locally in the vault_media directory.
     * If so, return the local file:// URI for completely offline playback.
     */
    fun resolveOfflineFirst(context: Context, remoteUrl: String): String {
        val fileName = remoteUrl.substringAfterLast("/")
        val localFile = File(File(context.filesDir, "vault_media"), fileName)
        return if (localFile.exists() && localFile.length() > 0) {
            localFile.toURI().toString()
        } else {
            remoteUrl
        }
    }

    /**
     * Resolve an image for a specific year.
     * If the decade folder doesn't exist (pre-1890), it falls back to the 1890s pool.
     */
    fun imageForYear(year: Int, index: Int = 0): String {
        val eraPath = if (year < 1963) "Pre Independence Kenya" else "Post Independence Kenya"
        val decade = (year / 10) * 10
        val decadeStr = "${decade}s"
        
        val eraKey = if (year < 1963) "Pre Independence Kenya" else "Post Independence Kenya"
        val folderKey = "$eraKey/$decadeStr"
        
        val files = MediaManifest.imagesByDecade[folderKey] 
            ?: MediaManifest.imagesByDecade["Pre Independence Kenya/1890s"] 
            ?: emptyList()
            
        if (files.isEmpty()) {
             return encodeUrl("images/Pre Independence Kenya/1910s/Kenya-Tribes.webp")
        }
        
        val fileName = files[index % files.size]
        return encodeUrl("images/$eraPath/$decadeStr/$fileName")
    }

    /**
     * Find all videos in the manifest that match the given year or decade.
     */
    fun getVideosForYear(year: Int): List<String> {
        return MediaManifest.allVideos.filter { fileName ->
            fileName.startsWith(year.toString()) || 
            (year in 1952..1960 && fileName.contains("Mau Mau", ignoreCase = true)) ||
            (year in 1950..1959 && fileName.contains("1950", ignoreCase = true))
        }.map { encodeUrl("videos/$it") }
    }

    /**
     * Retrieves all videos for a decade, precisely parsed by year and sorted.
     * Returns List<Pair<Year, URL>>
     */
    fun getVideosForDecade(year: Int): List<Pair<Int, String>> {
        val decade = (year / 10) * 10
        val decadeRange = decade..(decade + 9)
        
        return MediaManifest.allVideos.mapNotNull { fileName ->
            val videoYear = fileName.take(4).toIntOrNull()
            if (videoYear != null && videoYear in decadeRange) {
                videoYear to encodeUrl("videos/$fileName")
            } else if (fileName.contains("${decade}s") || 
                (decade == 1950 && fileName.contains("Mau Mau", ignoreCase = true))) {
                decade to encodeUrl("videos/$fileName")
            } else {
                null
            }
        }.sortedBy { it.first }
    }

    /**
     * Retrieves all archival photos for a specific decade folder.
     */
    fun getImagesForDecade(year: Int): List<String> {
        val decade = (year / 10) * 10
        val decadeStr = "${decade}s"
        val eraKey = if (year < 1963) "Pre Independence Kenya" else "Post Independence Kenya"
        val eraPath = if (year < 1963) "Pre Independence Kenya" else "Post Independence Kenya"
        val folderKey = "$eraKey/$decadeStr"
        
        val files = MediaManifest.imagesByDecade[folderKey] 
            ?: MediaManifest.imagesByDecade["Pre Independence Kenya/1890s"] 
            ?: emptyList()
            
        return files.map { encodeUrl("images/$eraPath/$decadeStr/$it") }
    }

    /**
     * Encodes a partial path into a full GitHub raw URL.
     * Prevents double-encoding by taking raw strings and applying %20 only once.
     */
    private fun encodeUrl(partialPath: String): String {
        val encoded = partialPath
            .replace(" ", "%20")
            .replace("(", "%28")
            .replace(")", "%29")
        return "$BASE/$encoded"
    }

    /**
     * Returns the GitHub raw video URL for a given video filename.
     */
    fun videoUrl(filename: String): String = encodeUrl("videos/$filename")

    /**
     * Attempts to find a video for a year or keyword.
     * This is used by the seeder to map videos like "MauMau" or "1963".
     */
    fun findVideoByKeyword(keyword: String, existingVideos: List<String>): String? {
        return existingVideos.find { it.contains(keyword, ignoreCase = true) }?.let { videoUrl(it) }
    }
}
