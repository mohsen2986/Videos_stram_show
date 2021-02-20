package com.videostreamshows.data.remote.model
import com.google.gson.annotations.SerializedName


data class TvTrending(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Tv>,
    @SerializedName("total_pages")
    val totalPages: Int, // 1000
    @SerializedName("total_results")
    val totalResults: Int // 20000
)

data class Tv(
    @SerializedName("backdrop_path")
    val backdropPath: String, // /lOr9NKxh4vMweufMOUDJjJhCRHW.jpg
    @SerializedName("first_air_date")
    val firstAirDate: String, // 2021-01-15
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int, // 85271
    @SerializedName("media_type")
    val mediaType: String, // tv
    @SerializedName("name")
    val name: String, // WandaVision
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_name")
    val originalName: String, // WandaVision
    @SerializedName("overview")
    val overview: String, // Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.
    @SerializedName("popularity")
    val popularity: Double, // 3342.43
    @SerializedName("poster_path")
    val posterPath: String, // /glKDfE6btIRcVB5zrjspRIs4r52.jpg
    @SerializedName("vote_average")
    val voteAverage: Double, // 8.4
    @SerializedName("vote_count")
    val voteCount: Int // 4745
)