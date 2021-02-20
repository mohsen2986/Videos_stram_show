package com.videostreamshows.data.remote.api

import com.haroldadmin.cnradapter.NetworkResponse
import com.videostreamshows.data.remote.model.*
import retrofit2.http.*

interface ApiInterface{

    @GET("tv/44217/credits")
    suspend fun getMovie(
    ): NetworkResponse< Credits , String>

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
    ): NetworkResponse< NowPlaying , String>

    @GET("trending/tv/day")
    suspend fun tvTrending(
       @Query("page") page: Int?
    ):NetworkResponse< TvTrending , String>

    @GET("trending/movie/day")
    suspend fun getMovieTrending(
            @Query("page") page: Int?
    ): NetworkResponse< MovieTrending , String>
    
    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
            @Path("movieId") movieId: String
    ): NetworkResponse< MovieDetail , String>

    @GET("tv/{tvId}")
    suspend fun getTvDetail(
            @Path("tvId") tvId: String
    ): NetworkResponse< TvDetails , String>

    @GET("genre/movie/list")
    suspend fun getMovieGenre(
    ): NetworkResponse< GenreCollection , String>

    @GET("movie/{movieId}/credits")
    suspend fun getMovieCredits(
            @Path("movieId") movieId: String
    ): NetworkResponse< Credits , String >

    @GET("tv/{tvId}/credits")
    suspend fun getTvCredits(
            @Path("tvId") tvId: String
    ): NetworkResponse< Credits , String >

    @GET("discover/movie")
    suspend fun getMovieBasedOnGenre(
            @Query("with_genres") genreId: String ,
            @Query("sort_by") sortBy: String = "popularity.desc"
    ): NetworkResponse< MovieTrending , Unit>

    @GET("movie/{movieId}/similar")
    suspend fun getSimilarMovie(
        @Path("movieId") movieId: String
    ): NetworkResponse<MovieTrending , Unit>

    // MOVIE TRENDING
//    https://api.themoviedb.org/3/trending/tv/day?api_key=6d79a6ece24a5b7fd995014cfec5c22d

//    https://api.themoviedb.org/3/trending/tv/day?api_key=6d79a6ece24a5b7fd995014cfec5c22d
//    https://api.themoviedb.org/3/trending/movie/day?api_key=6d79a6ece24a5b7fd995014cfec5c22d

//    TV detail
//    https://api.themoviedb.org/3/tv/44217?api_key=6d79a6ece24a5b7fd995014cfec5c22d
//    https://api.themoviedb.org/3/movie/12?api_key=6d79a6ece24a5b7fd995014cfec5c22d&language=en-US

    // ganres
//    https://api.themoviedb.org/3/genre/movie/list?api_key=6d79a6ece24a5b7fd995014cfec5c22d&language=en-US
//    tv
//    https://api.themoviedb.org/3/genre/tv/list?api_key=6d79a6ece24a5b7fd995014cfec5c22d&language=en-US

    // credits
    // https://api.themoviedb.org/3/tv/44217/credits?api_key=6d79a6ece24a5b7fd995014cfec5c22d&language=en-US
//    https://api.themoviedb.org/3/movie/{movie_id}/credits?api_key=6d79a6ece24a5b7fd995014cfec5c22d&language=en-US

    // similar movies
//    https://api.themoviedb.org/3/movie/{movie_id}/similar?api_key=6d79a6ece24a5b7fd995014cfec5c22d&language=en-US&page=1

//    https://api.themoviedb.org/3/discover/movie?api_key=6d79a6ece24a5b7fd995014cfec5c22d&language=en-US&sort_by=popularity.desc&page=1&with_genres=28
}