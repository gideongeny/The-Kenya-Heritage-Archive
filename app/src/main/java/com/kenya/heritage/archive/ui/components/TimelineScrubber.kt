package com.kenya.heritage.archive.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenya.heritage.archive.ui.theme.GoldAccent

@Composable
fun TimelineScrubber(
    currentYear: Int,
    range: IntRange = 1000..2026,
    onYearChanged: (Int) -> Unit
) {
    var offset by remember { mutableStateOf(0f) }
    val scrollState = rememberScrollableState { delta ->
        offset += delta
        val totalYears = range.last - range.first
        val yearDelta = (delta / 10).toInt() // Sensitivity
        val newYear = (currentYear - yearDelta).coerceIn(range.first, range.last)
        if (newYear != currentYear) onYearChanged(newYear)
        delta
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))
                )
            )
            .scrollable(scrollState, Orientation.Horizontal),
        contentAlignment = Alignment.Center
    ) {
        // Timeline ticks and years
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = size.width / 2
            val spacing = 40.dp.toPx()
            
            for (i in -10..10) {
                val yearToDraw = currentYear + i
                if (yearToDraw in range) {
                    val x = center + (i * spacing)
                    val height = if (yearToDraw % 10 == 0) 40.dp.toPx() else 20.dp.toPx()
                    val thickness = if (yearToDraw % 10 == 0) 2.dp.toPx() else 1.dp.toPx()
                    
                    drawLine(
                        color = if (i == 0) GoldAccent else Color.Gray,
                        start = androidx.compose.ui.geometry.Offset(x, size.height - height),
                        end = androidx.compose.ui.geometry.Offset(x, size.height),
                        strokeWidth = thickness
                    )
                }
            }
        }

        // Current Year Indicator
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = currentYear.toString(),
                style = MaterialTheme.typography.headlineLarge,
                color = GoldAccent,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = getEpochName(currentYear),
                style = MaterialTheme.typography.labelMedium,
                color = GoldAccent.copy(alpha = 0.7f)
            )
        }
    }
}

private fun getEpochName(year: Int): String = when {
    year < 1500 -> "Pre-Colonial Kingdoms"
    year < 1880 -> "The Great Exploration"
    year < 1920 -> "Colonial Resistance"
    year < 1963 -> "The Road to Independence"
    else -> "Modern Republic"
}
