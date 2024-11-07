package com.azelder.fetchhiring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azelder.model.data.HiringModel
import com.example.data.FetchHiringRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    fetchHiringRepository: FetchHiringRepository
) : ViewModel() {

    val uiState: StateFlow<MainListUiState> = fetchHiringRepository.getHiringList().map {
        MainListUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainListUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )
}

sealed interface MainListUiState {
    data object Loading : MainListUiState
    data class Success(val hiringList: List<HiringModel>) : MainListUiState
}