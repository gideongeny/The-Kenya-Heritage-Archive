package com.kenya.heritage.archive.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kenya.heritage.archive.data.model.HistoricalArtifact
import com.kenya.heritage.archive.ui.viewmodel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBack: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchResults by viewModel.searchResults.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    
    val focusManager = LocalFocusManager.current
    var selectedArtifactForVault by remember { mutableStateOf<HistoricalArtifact?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        TextField(
                            value = searchQuery,
                            onValueChange = { viewModel.onSearchQueryChanged(it) },
                            placeholder = { Text("Search places, people, events...") },
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() }),
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { 
                                viewModel.onSearchQueryChanged("") 
                                focusManager.clearFocus()
                            }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                if (searchQuery.length < 2) {
                    // Empty State
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = Color.Gray.copy(alpha = 0.5f)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Search the Archive",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Find artifacts by title, location, or story",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray.copy(alpha = 0.8f)
                        )
                    }
                } else if (searchResults.isEmpty()) {
                    // No Results State
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "No artifacts found",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Gray
                        )
                        Text(
                            text = "Try searching for another keyword or location.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray.copy(alpha = 0.8f)
                        )
                    }
                } else {
                    // Results State
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Text(
                                text = "Found ${searchResults.size} results",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                        items(searchResults) { artifact ->
                            ArtifactCard(
                                artifact = artifact,
                                isForeignerGuideEnabled = false,
                                onEnterVault = { selectedArtifactForVault = artifact }
                            )
                        }
                    }
                }
            }
        }

        // Vault Gallery Overlay
        if (selectedArtifactForVault != null) {
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
