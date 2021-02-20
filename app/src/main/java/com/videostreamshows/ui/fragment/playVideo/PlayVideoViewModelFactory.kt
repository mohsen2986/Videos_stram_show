package com.videostreamshows.ui.fragment.playVideo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlayVideoViewModelFactory(
): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlayVideoViewModel() as T
    }
}