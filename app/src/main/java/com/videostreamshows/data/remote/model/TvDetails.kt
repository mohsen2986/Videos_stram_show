package com.videostreamshows.data.remote.model
import com.google.gson.annotations.SerializedName


data class TvDetails(
    @SerializedName("backdrop_path")
    val backdropPath: String, // /aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg
    @SerializedName("created_by")
    val createdBy: List<CreatedBy>,
    @SerializedName("episode_run_time")
    val episodeRunTime: List<Int>,
    @SerializedName("first_air_date")
    val firstAirDate: String, // 2013-03-03
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String, // http://www.history.com/shows/vikings
    @SerializedName("id")
    val id: Int, // 44217
    @SerializedName("in_production")
    val inProduction: Boolean, // false
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("last_air_date")
    val lastAirDate: String, // 2020-12-30
    @SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir,
    @SerializedName("name")
    val name: String, // Vikings
    @SerializedName("networks")
    val networks: List<Network>,
    @SerializedName("next_episode_to_air")
    val nextEpisodeToAir: Any, // null
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int, // 89
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int, // 6
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_name")
    val originalName: String, // Vikings
    @SerializedName("overview")
    val overview: String, // The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.
    @SerializedName("popularity")
    val popularity: Double, // 607.853
    @SerializedName("poster_path")
    val posterPath: String, // /bQLrHIRNEkE3PdIWQrZHynQZazu.jpg
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("seasons")
    val seasons: List<Season>,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String, // Ended
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("type")
    val type: String, // Scripted
    @SerializedName("vote_average")
    val voteAverage: String, // 8
    @SerializedName("vote_count")
    val voteCount: Int // 4061
)

data class CreatedBy(
    @SerializedName("credit_id")
    val creditId: String, // 5259670b760ee346619c36f2
    @SerializedName("gender")
    val gender: Int, // 2
    @SerializedName("id")
    val id: Int, // 37631
    @SerializedName("name")
    val name: String, // Michael Hirst
    @SerializedName("profile_path")
    val profilePath: Any // null
)

data class LastEpisodeToAir(
    @SerializedName("air_date")
    val airDate: String, // 2020-12-30
    @SerializedName("episode_number")
    val episodeNumber: String, // 20
    @SerializedName("id")
    val id: Int, // 2582994
    @SerializedName("name")
    val name: String, // The Last Act
    @SerializedName("overview")
    val overview: String, // Ubbe reunites with an old friend but must pass judgment on a killer. The armies of Alfred and Ivar clash as each leader looks to his god for strength.
    @SerializedName("production_code")
    val productionCode: String,
    @SerializedName("season_number")
    val seasonNumber: Int, // 6
    @SerializedName("still_path")
    val stillPath: String, // /5NmZRvgBV0IRtx1tYVuMyCalx41.jpg
    @SerializedName("vote_average")
    val voteAverage: String, // 7
    @SerializedName("vote_count")
    val voteCount: Int // 2
)

data class Network(
    @SerializedName("id")
    val id: Int, // 1024
    @SerializedName("logo_path")
    val logoPath: String, // /uK6yuqMkUvKhCgVJjg5JWDUoabA.png
    @SerializedName("name")
    val name: String, // Amazon
    @SerializedName("origin_country")
    val originCountry: String
)

data class Season(
    @SerializedName("air_date")
    val airDate: String, // 2013-02-25
    @SerializedName("episode_count")
    val episodeCount: Int, // 7
    @SerializedName("id")
    val id: Int, // 53335
    @SerializedName("name")
    val name: String, // Specials
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String, // /woP1jNltcWMLqK6pcFqPJq6pyJ6.jpg
    @SerializedName("season_number")
    val seasonNumber: Int // 0
)
