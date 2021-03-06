package com.videostreamshows.data.remote

import com.videostreamshows.data.remote.api.ApiInterface
import retrofit2.Retrofit

class CreateApiInterface(
    private val retrofit: Retrofit
){
    operator fun invoke(): ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }
}