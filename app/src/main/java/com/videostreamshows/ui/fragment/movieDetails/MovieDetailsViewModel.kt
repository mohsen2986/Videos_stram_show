package com.videostreamshows.ui.fragment.movieDetails

import androidx.lifecycle.ViewModel
import com.videostreamshows.data.repository.DataRepository

class MovieDetailsViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    suspend fun movieDetail(movieId: String) =
            dataRepository.getMovieDetail(movieId)

    suspend fun movieCredits(movieId: String) =
            dataRepository.getMovieCredits(movieId)

    suspend fun similarMovies(movieId: String) =
        dataRepository.getSimilarMovie(movieId)
}