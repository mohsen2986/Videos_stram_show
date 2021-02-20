package com.videostreamshows.data.remote.model
import com.google.gson.annotations.SerializedName


data class NowPlaying(
        @SerializedName("dates")
    val dates: Dates,
        @SerializedName("page")
    val page: Int, // 1
        @SerializedName("results")
    val movies: List<Movie>,
        @SerializedName("total_pages")
    val totalPages: Int, // 43
        @SerializedName("total_results")
    val totalResults: Int // 849
)

data class Dates(
    @SerializedName("maximum")
    val maximum: String, // 2021-02-14
    @SerializedName("minimum")
    val minimum: String // 2020-12-28
)

