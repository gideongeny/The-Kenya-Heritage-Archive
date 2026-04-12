package com.kenya.heritage.archive.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kenya.heritage.archive.data.model.HistoricalArtifact
import com.kenya.heritage.archive.data.repository.ArtifactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: ArtifactRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<HistoricalArtifact>>(emptyList())
    val searchResults: StateFlow<List<HistoricalArtifact>> = _searchResults.asStateFlow()

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        if (query.length >= 2) {
            executeSearch(query)
        } else {
            _searchResults.value = emptyList()
        }
    }

    private fun executeSearch(query: String) {
        viewModelScope.launch {
            repository.searchArtifacts(query).collect { results ->
                _searchResults.value = results
            }
        }
    }
}
