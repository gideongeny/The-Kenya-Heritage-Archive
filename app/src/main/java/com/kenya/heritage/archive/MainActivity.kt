package com.kenya.heritage.archive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.kenya.heritage.archive.ui.screens.MainScreen
import com.kenya.heritage.archive.ui.theme.HeritageTheme
import com.kenya.heritage.archive.ui.viewmodel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.background

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply stored language before super.onCreate
        com.kenya.heritage.archive.data.util.LanguageManager.applyStoredLanguage(this)
        
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display for the cinematic experience
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            HeritageTheme {
                var currentScreen by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("TIMELINE") }
                
                var selectedArtifactForVault by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf<com.kenya.heritage.archive.data.model.HistoricalArtifact?>(null) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    androidx.compose.foundation.layout.Box(modifier = Modifier.fillMaxSize()) {
                        when (currentScreen) {
                            "SEARCH" -> {
                                com.kenya.heritage.archive.ui.screens.SearchScreen(
                                    onBack = { currentScreen = "TIMELINE" }
                                )
                            }
                            "MAP" -> {
                                val uiState by viewModel.uiState.collectAsState()
                                com.kenya.heritage.archive.ui.screens.MapScreen(
                                    artifacts = uiState.artifacts,
                                    onBack = { currentScreen = "TIMELINE" },
                                    onArtifactSelected = { artifact ->
                                        selectedArtifactForVault = artifact
                                    }
                                )
                            }
                            else -> {
                                MainScreen(
                                    viewModel = viewModel,
                                    onNavigateToSearch = { currentScreen = "SEARCH" },
                                    onNavigateToMap = { currentScreen = "MAP" }
                                )
                            }
                        }
                        
                        if (selectedArtifactForVault != null) {
                            androidx.compose.foundation.layout.Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(androidx.compose.ui.graphics.Color.Black)
                            ) {
                                com.kenya.heritage.archive.ui.screens.VaultGallery(
                                    artifact = selectedArtifactForVault!!,
                                    onClose = { selectedArtifactForVault = null }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
