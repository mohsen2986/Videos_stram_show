package com.videostreamshows.data.remote.model
import com.google.gson.annotations.SerializedName


data class MovieTrending(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int, // 1000
    @SerializedName("total_results")
    val totalResults: Int // 20000
)