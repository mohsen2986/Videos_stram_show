package com.videostreamshows.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.haroldadmin.cnradapter.executeWithRetry
import com.videostreamshows.data.remote.api.ApiInterface
import com.videostreamshows.data.remote.model.Genre
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.data.remote.model.Tv
import com.videostreamshows.ui.base.lazyDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataRepository(
    private val apiInterface: ApiInterface
){
    init {
//        GlobalScope.launch(IO) {
//            data.await()
//            topMovie.await()
//            topTv.await()
//            genres.await()
//        }
    }
    // now playing (slider item
    val data: Deferred<List<Movie>> by lazyDeferred {
        withContext(IO){
            when(val callback = executeWithRetry(times = 6) {apiInterface.getNowPlaying()}){
                is NetworkResponse.Success -> callback.body.movies.takeLast(7)
                else -> null!!
            }
        }
    }
    // top movies
    val topMovie: Deferred<List<Movie>> by lazyDeferred {
        withContext(IO){
            when(val callback = executeWithRetry(times = 6) {apiInterface.getNowPlaying()}){
                is NetworkResponse.Success -> callback.body.movies.takeLast(7)
                else -> null!!
            }
        }
    }
    // top tv
    val topTv: Deferred<List<Tv>> by lazyDeferred {
        withContext(IO){
            when(val callback = executeWithRetry(times = 6) {apiInterface.tvTrending(null)}){
                is NetworkResponse.Success -> callback.body.results
                else -> null!!
            }
        }
    }
    // genres
    val genres: Deferred<List<Genre>> by lazyDeferred {
        withContext(IO){
            when(val callback = executeWithRetry(times = 6) {apiInterface.getMovieGenre()}){
                is NetworkResponse.Success -> callback.body.genres
                else -> null!!
            }
        }
    }

    suspend fun getMovies() =
        apiInterface.getMovie()

    suspend fun getNowPlaying() =
            apiInterface.getNowPlaying()

    suspend fun getTvTrending() =
            apiInterface.tvTrending(null)

    suspend fun getMovieTrending(page: Int?) =
            apiInterface.getMovieTrending(page)

    suspend fun getMovieGenre() =
            apiInterface.getMovieGenre()

    suspend fun getMovieBasedOnGenre(genreId: String) =
            apiInterface.getMovieBasedOnGenre(genreId)

    suspend fun getMovieDetail(movieId: String) =
            apiInterface.getMovieDetail(movieId)

    suspend fun getMovieCredits(movieId: String) =
            apiInterface.getMovieCredits(movieId)

    suspend fun getSimilarMovie(movieId: String) =
        apiInterface.getSimilarMovie(movieId)

    suspend fun getTvDetails(tvId: String) =
            apiInterface.getTvDetail(tvId)

    suspend fun getTvCredits(tvId: String) =
            apiInterface.getTvCredits(tvId)
}