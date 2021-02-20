package com.videostreamshows.data.remote.model
import com.google.gson.annotations.SerializedName


data class GenreCollection(
    @SerializedName("genres")
    val genres: List<Genre>
)
