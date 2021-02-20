package com.videostreamshows.ui.fragment.mainPage

import androidx.lifecycle.ViewModel
import com.videostreamshows.data.repository.DataRepository

class MainPageViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    fun boarder() = dataRepository.data
    fun topMovie() = dataRepository.topMovie
    fun topTv() = dataRepository.topTv
    fun genres() = dataRepository.genres


    suspend fun movie() =
        dataRepository.getMovies()

    suspend fun movieGenre() =
            dataRepository.getMovieGenre()

    suspend fun movieBasedOnGenre(genderId: String) =
            dataRepository.getMovieBasedOnGenre(genderId)
}