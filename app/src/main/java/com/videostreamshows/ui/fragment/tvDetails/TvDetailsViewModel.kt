package com.videostreamshows.ui.fragment.tvDetails

import androidx.lifecycle.ViewModel
import com.videostreamshows.data.repository.DataRepository

class TvDetailsViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    suspend fun tvDetails(tvId: String) =
            dataRepository.getTvDetails(tvId)

    suspend fun tvCredits(tvId: String) =
            dataRepository.getTvCredits(tvId)
}