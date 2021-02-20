package com.videostreamshows.ui.fragment.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.videostreamshows.data.repository.DataRepository

class MovieDetailsViewModelFactory(
    private val dataRepository: DataRepository
): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(dataRepository) as T
    }
}