package com.videostreamshows.data.dataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.videostreamshows.data.repository.DataRepository
import kotlinx.coroutines.CoroutineScope

class MovieDataSourceFactory<T>(
    private val repository: DataRepository,
    private var query: String,
    private val scope: CoroutineScope
):DataSource.Factory<Int , T>(){
    val source = MutableLiveData<MovieDataSource<T>>()

    override fun create(): DataSource<Int, T> {
        val source = MovieDataSource<T>(repository, query, scope)
        this.source.postValue(source)
        return source
    }

    // --- PUBLIC API
    fun getSource() = source.value
    fun getQuery() = query

    fun updateQuery(query:String){
        this.query = query
        getSource()?.refresh()
    }

}