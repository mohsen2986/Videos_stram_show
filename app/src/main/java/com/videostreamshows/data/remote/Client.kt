package com.videostreamshows.data.remote

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class Client(
){
    operator fun invoke(): OkHttpClient{
        val client : OkHttpClient by lazy {
            val builder = OkHttpClient.Builder()
                    .addInterceptor(object: Interceptor{
                        override fun intercept(chain: Interceptor.Chain): Response {
                            var request = chain.request()

                            val originalHttpUrl: HttpUrl = request.url

                            val url: HttpUrl = originalHttpUrl.newBuilder()
                                    .addQueryParameter("api_key", "6d79a6ece24a5b7fd995014cfec5c22d")
                                    .addQueryParameter("language" , "language=en-US")
                                    .build()

                            val builder = request.newBuilder()
                                    .addHeader("Accept", "application/json")
                                    .addHeader("Connection", "close")
                                    .url(url)

                            request = builder.build()
                            return chain.proceed(request)
                        }
                    })
            builder.addNetworkInterceptor(StethoInterceptor())
            builder.build()
        }
        return client
    }
}