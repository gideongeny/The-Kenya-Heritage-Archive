package com.kenya.heritage.archive.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val HeritageDarkColorScheme = darkColorScheme(
    primary = GoldAccent,
    onPrimary = DarkGray,
    secondary = GoldMuted,
    onSecondary = DarkGray,
    background = DarkGray,
    onBackground = TextGray,
    surface = SurfaceGray,
    onSurface = TextGray,
    error = ErrorRed
)

@Composable
fun HeritageTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = HeritageDarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
