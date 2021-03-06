package com.videostreamshows.data.remote

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder(
        private val client: OkHttpClient
){
    companion object{
        private const val URL = "https://api.themoviedb.org/3/"
    }
    operator fun invoke(): Retrofit{
        return Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addCallAdapterFactory(NetworkResponseAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}