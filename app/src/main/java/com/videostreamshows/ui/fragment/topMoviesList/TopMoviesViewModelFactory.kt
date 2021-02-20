package com.videostreamshows.ui.fragment.topMoviesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.videostreamshows.data.repository.DataRepository

class TopMoviesViewModelFactory(
        private val dataRepository: DataRepository
):ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopMoviesViewModel(dataRepository) as T
    }
}