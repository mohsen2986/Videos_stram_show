package com.videostreamshows.ui.fragment.tvDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.videostreamshows.data.repository.DataRepository

class TvDetailsViewModelFactory(
    private val dataRepository: DataRepository
): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvDetailsViewModel(dataRepository) as T
    }
}