package com.kenya.heritage.archive.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kenya.heritage.archive.data.model.HistoricalArtifact
import com.kenya.heritage.archive.data.repository.ArtifactRepository
import com.kenya.heritage.archive.data.util.HistoricalSeeder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HistoryUiState(
    val currentYear: Int = 1963,
    val artifacts: List<HistoricalArtifact> = emptyList(),
    val featuredArtifact: HistoricalArtifact? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: ArtifactRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HistoryUiState())
    val uiState: StateFlow<HistoryUiState> = _uiState.asStateFlow()

    init {
        seedIfEmpty()
        loadFeaturedArtifact()
        observeArtifactsByYear(1963)
    }

    private fun seedIfEmpty() {
        viewModelScope.launch {
            val count = repository.count()
            // Detect 'stale' or incomplete local data and force a refresh to sync with GitHub
            val isStale = if (count > 0) {
                val sample = repository.getArtifactsByRange(1960, 1965).first().firstOrNull()
                // If the data doesn't contain GitHub URLs, it's stale
                sample != null && sample.bannerImageUrl?.contains("raw.githubusercontent") == false
            } else false

            if (count == 0 || isStale) {
                if (isStale) repository.refreshArtifacts() // Wipes the DB
                val seed = HistoricalSeeder.getDeepHeritageStitch()
                repository.insertSeeds(seed)
            }
        }
    }

    private fun loadFeaturedArtifact() {
        viewModelScope.launch {
            repository.getFeaturedArtifact().collect { artifact ->
                _uiState.update { it.copy(featuredArtifact = artifact) }
            }
        }
    }

    fun onYearChanged(newYear: Int) {
        _uiState.update { it.copy(currentYear = newYear) }
        observeArtifactsByYear(newYear)
    }

    private fun observeArtifactsByYear(year: Int) {
        viewModelScope.launch {
            // Update the list of artifacts for the specific year range
            repository.getArtifactsByRange(year - 10, year + 10).collect { list ->
                _uiState.update { it.copy(artifacts = list) }
            }
        }
        
        viewModelScope.launch {
            // Dynamically update the 'Featured Era' banner based on the current decade
            repository.getArtifactsByRange(year - 5, year + 5).collect { list ->
                // Try to find a featured item in the current range, or just the most prominent one
                val featured = list.find { it.decadeDescription != null } ?: list.firstOrNull()
                _uiState.update { it.copy(featuredArtifact = featured) }
            }
        }
    }

    fun syncData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                repository.refreshArtifacts()
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message) }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}
