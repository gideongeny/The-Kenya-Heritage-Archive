package com.kenya.heritage.archive.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.kenya.heritage.archive.R
import com.kenya.heritage.archive.data.model.HistoricalArtifact
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    artifacts: List<HistoricalArtifact>,
    onBack: () -> Unit,
    onArtifactSelected: (HistoricalArtifact) -> Unit
) {
    val context = LocalContext.current
    val mapState = remember { MapState() }

    // Initialize osmdroid configuration to strictly use internal cache
    LaunchedEffect(Unit) {
        val basePath = File(context.cacheDir.absolutePath, "osmdroid")
        basePath.mkdirs()
        Configuration.getInstance().osmdroidBasePath = basePath
        val tileCache = File(Configuration.getInstance().osmdroidBasePath.absolutePath, "tile")
        tileCache.mkdirs()
        Configuration.getInstance().osmdroidTileCache = tileCache
        Configuration.getInstance().userAgentValue = context.packageName
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Geographic Heritage Map", color = MaterialTheme.colorScheme.primary)
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                AndroidView(
                    modifier = Modifier.fillMaxSize(),
                    factory = { ctx ->
                        MapView(ctx).apply {
                            setMultiTouchControls(true)
                            zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
                            
                            // Center on Kenya
                            controller.setZoom(6.0)
                            controller.setCenter(GeoPoint(0.1768696, 37.906193))
                        }
                    },
                    update = { view ->
                        // Clear existing overlays to prevent duplicates on state changes
                        view.overlays.clear()

                        artifacts.filter { it.latitude != null && it.longitude != null }.forEach { artifact ->
                            val marker = Marker(view)
                            marker.position = GeoPoint(artifact.latitude!!, artifact.longitude!!)
                            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                            marker.title = artifact.title
                            marker.snippet = "${artifact.year} • ${artifact.period}"
                            
                            // Set a custom icon later if needed, default is fine for now
                            
                            marker.setOnMarkerClickListener { _, _ ->
                                onArtifactSelected(artifact)
                                true
                            }
                            
                            view.overlays.add(marker)
                        }
                        view.invalidate()
                    }
                )
            }
        }
    }
}

class MapState {
    // Hold any map specific state here if needed
}
