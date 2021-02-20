package com.videostreamshows.ui.fragment.topMoviesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.videostreamshows.data.dataSource.MovieDataSourceFactory
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.data.remote.model.NetworkState
import com.videostreamshows.data.repository.DataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

class TopMoviesViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    // paging
    // DATA
    protected val ioScope = CoroutineScope(Dispatchers.IO)

    private val itemDataSource = MovieDataSourceFactory<Movie>(repository = dataRepository, query = "", scope = ioScope)

    // OBSERVABLES
    val users = LivePagedListBuilder(itemDataSource ,pagedListConfig()).build()
    val networkState : LiveData<NetworkState>? =
        Transformations.switchMap(itemDataSource.source) { it.getNetworkState() }


    fun fetchQuery(query:String){
        if(itemDataSource.getQuery() == query) return
        itemDataSource.updateQuery(query = query)
    }
    fun getQuery() = itemDataSource.getQuery()
    // refresh all list after an issue
    fun refreshAllList() = itemDataSource.getSource()?.refresh()

    // UTILS
    private fun pagedListConfig() =
        PagedList.Config.Builder()
            .setInitialLoadSizeHint(5)
            .setEnablePlaceholders(false)
            .setPageSize(5)
            .build()

    override fun onCleared() {
        super.onCleared()
        ioScope.coroutineContext.cancel()
    }

}