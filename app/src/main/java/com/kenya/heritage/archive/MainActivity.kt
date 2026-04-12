package com.kenya.heritage.archive

import android.os.Bundle
import androidx.activity.ComponentActivity
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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display for the cinematic experience
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            HeritageTheme {
                var isSearchActive by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (isSearchActive) {
                        com.kenya.heritage.archive.ui.screens.SearchScreen(
                            onBack = { isSearchActive = false }
                        )
                    } else {
                        MainScreen(
                            viewModel = viewModel,
                            onNavigateToSearch = { isSearchActive = true }
                        )
                    }
                }
            }
        }
    }
}
