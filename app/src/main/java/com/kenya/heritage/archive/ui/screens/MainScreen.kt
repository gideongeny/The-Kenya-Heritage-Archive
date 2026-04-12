package com.kenya.heritage.archive.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.activity.compose.BackHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kenya.heritage.archive.data.model.AssetType
import com.kenya.heritage.archive.data.model.HistoricalArtifact
import com.kenya.heritage.archive.data.util.GitHubAssetResolver
import com.kenya.heritage.archive.ui.components.TimelineScrubber
import com.kenya.heritage.archive.ui.util.VideoThumbnailLoader
import com.kenya.heritage.archive.ui.viewmodel.HistoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: HistoryViewModel, onNavigateToSearch: () -> Unit = {}) {
    val uiState by viewModel.uiState.collectAsState()
    var isForeignerGuideEnabled by remember { mutableStateOf(false) }
    var showPrivacyPolicy by remember { mutableStateOf(false) }

    var selectedArtifactForVault by remember { mutableStateOf<HistoricalArtifact?>(null) }

    if (showPrivacyPolicy) {
        BackHandler { showPrivacyPolicy = false }
        PrivacyScreen(onBack = { showPrivacyPolicy = false })
        return
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Kenya Heritage Archive",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    actions = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(end = 4.dp)
                        ) {
                            IconButton(onClick = onNavigateToSearch) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                            TextButton(onClick = { showPrivacyPolicy = true }) {
                                Text(
                                    "Privacy",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                                )
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                "Guide",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Switch(
                                checked = isForeignerGuideEnabled,
                                onCheckedChange = { isForeignerGuideEnabled = it },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            },
            bottomBar = {
                TimelineScrubber(
                    currentYear = uiState.currentYear,
                    onYearChanged = viewModel::onYearChanged
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        EraOfTheDayCard(uiState.featuredArtifact, uiState.currentYear)
                    }

                    // NEW: Decade Media Galleries (Photos and Videos Separate)
                    if (uiState.decadePhotos.isNotEmpty() || uiState.decadeVideos.isNotEmpty()) {
                        item {
                            DecadeMediaSection(
                                year = uiState.currentYear,
                                photos = uiState.decadePhotos,
                                videos = uiState.decadeVideos,
                                onMediaClick = { type, url ->
                                    // Map to a dummy artifact for the vault to display
                                    val dummy = HistoricalArtifact(
                                        id = "temp_media",
                                        title = "Archival Discovery",
                                        year = uiState.currentYear,
                                        period = "Vault Asset",
                                        deepNarrative = "Discovering rare media from the archive.",
                                        category = com.kenya.heritage.archive.data.model.HistoricalCategory.CULTURAL,
                                        mediaAssets = listOf(com.kenya.heritage.archive.data.model.MediaAsset(url, type))
                                    )
                                    selectedArtifactForVault = dummy
                                }
                            )
                        }
                    }

                    if (uiState.artifacts.isEmpty()) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 48.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        "Scroll the timeline to explore Kenya's history",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = Color.Gray
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        "From the 11th Century to 2026",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
                                    )
                                }
                            }
                        }
                    } else {
                        item {
                            Text(
                                text = "Events around ${uiState.currentYear}",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        items(uiState.artifacts) { artifact ->
                            ArtifactCard(
                                artifact = artifact,
                                isForeignerGuideEnabled = isForeignerGuideEnabled,
                                onEnterVault = { selectedArtifactForVault = artifact }
                            )
                        }
                    }
                }

                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // Vault Gallery Overlay (TRUE FULL SCREEN)
        if (selectedArtifactForVault != null) {
            BackHandler { selectedArtifactForVault = null }
            
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                VaultGallery(
                    artifact = selectedArtifactForVault!!,
                    onClose = { selectedArtifactForVault = null }
                )
            }
        }
    }
}

@Composable
fun EraOfTheDayCard(artifact: HistoricalArtifact?, currentYear: Int = 1963) {
    val title = artifact?.title ?: when {
        currentYear < 1500 -> "The Dawn of the Swahili Civilisation"
        currentYear < 1700 -> "The Age of Resistance & Forts"
        currentYear < 1895 -> "The Era of Coastal Dynasties"
        currentYear < 1963 -> "The Colonial Struggle"
        else -> "The Modern Republic"
    }
    val subtitle = if (artifact != null) {
        "${artifact.period} • ${artifact.historicalEpoch}"
    } else {
        "${(currentYear / 100) + 1}${getCenturySuffix((currentYear / 100) + 1)} Century • Kenya Heritage"
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = artifact?.bannerImageUrl 
                    ?: GitHubAssetResolver.getImagesForDecade(currentYear).firstOrNull() 
                    ?: GitHubAssetResolver.imageForYear(currentYear),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.4f
            )
            
            // Gradient Overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))
                        )
                    )
            )
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.25f),
                    shape = MaterialTheme.shapes.extraSmall
                ) {
                    Text(
                        text = "ERA OF THE DAY",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.85f)
                )
            }
        }
    }
}

private fun getCenturySuffix(century: Int): String {
    return when (century % 10) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
}

@Composable
fun ArtifactCard(
    artifact: HistoricalArtifact,
    isForeignerGuideEnabled: Boolean = false,
    onEnterVault: () -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    // Use bannerImageUrl from GitHub for the card thumbnail when no video
    val thumbnailUrl = artifact.bannerImageUrl
        ?: artifact.mediaAssets.firstOrNull { it.type == AssetType.IMAGE }?.url

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
        ),
        onClick = { isExpanded = !isExpanded }
    ) {
        Column {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Thumbnail: GitHub image or video frame
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(0xFF2D2D2D), MaterialTheme.shapes.small),
                    contentAlignment = Alignment.Center
                ) {
                    val videoRequest = VideoThumbnailLoader.createThumbnailRequest(context, artifact)
                    when {
                        videoRequest != null -> {
                            AsyncImage(
                                model = videoRequest,
                                imageLoader = VideoThumbnailLoader.getImageLoader(context),
                                contentDescription = artifact.title,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        thumbnailUrl != null -> {
                            AsyncImage(
                                model = thumbnailUrl,
                                contentDescription = artifact.title,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        else -> {
                            Text(
                                text = artifact.year.toString(),
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    if (artifact.mediaAssets.any { it.type == AssetType.VIDEO }) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black.copy(alpha = 0.3f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null,
                                modifier = Modifier.size(36.dp),
                                tint = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "${artifact.year} · ${artifact.period}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = artifact.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    if (!isExpanded) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = artifact.deepNarrative,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.LightGray,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            if (isExpanded) {
                Column(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
                    Spacer(modifier = Modifier.height(12.dp))

                    // Decade description
                    if (!artifact.decadeDescription.isNullOrBlank()) {
                        Text(
                            text = "THE DECADE",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = artifact.decadeDescription,
                            style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                            color = Color.LightGray
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(color = Color.White.copy(alpha = 0.1f))
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    // Deep narrative
                    Text(
                        text = "THE STORY",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = artifact.deepNarrative,
                        style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 24.sp),
                        color = Color.White.copy(alpha = 0.9f)
                    )

                    // Significant event
                    if (!artifact.significantEvent.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Surface(
                            color = Color(0xFF1B3A1B),
                            shape = MaterialTheme.shapes.small,
                            border = BorderStroke(1.dp, Color(0xFF4CAF50).copy(alpha = 0.5f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "🏛  SIGNIFICANT EVENT",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color(0xFF81C784),
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = artifact.significantEvent,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.White.copy(alpha = 0.9f)
                                )
                            }
                        }
                    }

                    // Fun fact
                    if (!artifact.funFact.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Surface(
                            color = Color(0xFF1A1A2E),
                            shape = MaterialTheme.shapes.small,
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "FUN FACT",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = artifact.funFact,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.White.copy(alpha = 0.9f)
                                )
                            }
                        }
                    }

                    // Foreigner's Guide
                    if (isForeignerGuideEnabled && !artifact.foreignerTips.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Surface(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                            shape = MaterialTheme.shapes.small,
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "🌍  FOREIGNER'S GUIDE",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = artifact.foreignerTips,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.LightGray
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            val sendIntent = android.content.Intent().apply {
                                action = android.content.Intent.ACTION_SEND
                                putExtra(
                                    android.content.Intent.EXTRA_TEXT,
                                    "Discover Kenya's History 🇰🇪\n\n${artifact.title} (${artifact.year})\n\n${artifact.deepNarrative}\n\nExplore more on the Kenya Heritage Archive app!"
                                )
                                type = "text/plain"
                            }
                            context.startActivity(android.content.Intent.createChooser(sendIntent, "Share artifact to..."))
                        }) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        OutlinedButton(
                            onClick = onEnterVault,
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = MaterialTheme.colorScheme.primary
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("ENTER THE VAULT")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DecadeMediaSection(
    year: Int,
    photos: List<String>,
    videos: List<Pair<Int, String>>,
    onMediaClick: (AssetType, String) -> Unit
) {
    val decade = (year / 10) * 10
    
    Column(modifier = Modifier.fillMaxWidth()) {
        if (photos.isNotEmpty()) {
            Text(
                text = "Archival Photos of the ${decade}s",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            MediaHorizontalGallery(
                items = photos,
                type = AssetType.IMAGE,
                onItemClick = { url -> onMediaClick(AssetType.IMAGE, url) }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        
        if (videos.isNotEmpty()) {
            Text(
                text = "Annual Chronicles of the ${decade}s",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            MediaHorizontalGallery(
                videoItems = videos,
                type = AssetType.VIDEO,
                onItemClick = { url -> onMediaClick(AssetType.VIDEO, url) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun MediaHorizontalGallery(
    items: List<String> = emptyList(),
    videoItems: List<Pair<Int, String>> = emptyList(),
    type: AssetType,
    onItemClick: (String) -> Unit
) {
    androidx.compose.foundation.lazy.LazyRow(
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(end = 16.dp)
    ) {
        if (type == AssetType.IMAGE) {
            items(items) { url ->
                Card(
                    modifier = Modifier
                        .size(200.dp, 120.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    onClick = { onItemClick(url) }
                ) {
                    AsyncImage(
                        model = url,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        } else {
            items(videoItems) { (year, url) ->
                Card(
                    modifier = Modifier
                        .size(200.dp, 120.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    onClick = { onItemClick(url) }
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        listOf(Color(0xFF2D2D2D), Color.Black)
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow, 
                                    contentDescription = null, 
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(40.dp)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = year.toString(),
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

