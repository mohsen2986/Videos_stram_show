package com.videostreamshows

import android.app.Application
import com.facebook.stetho.Stetho
import com.videostreamshows.data.remote.Client
import com.videostreamshows.data.remote.CreateApiInterface
import com.videostreamshows.data.remote.RetrofitBuilder
import com.videostreamshows.data.remote.api.ApiInterface
import com.videostreamshows.data.repository.DataRepository
import com.videostreamshows.ui.fragment.mainPage.MainPageViewModelFactory
import com.videostreamshows.ui.fragment.movieDetails.MovieDetailsViewModelFactory
import com.videostreamshows.ui.fragment.playVideo.PlayVideoViewModelFactory
import com.videostreamshows.ui.fragment.splashScreen.SplashScreenViewModelFactory
import com.videostreamshows.ui.fragment.topMoviesList.TopMoviesFragment
import com.videostreamshows.ui.fragment.topMoviesList.TopMoviesViewModelFactory
import com.videostreamshows.ui.fragment.tvDetails.TvDetailsViewModelFactory
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

class VideoStreamApplication(
): Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@VideoStreamApplication))

        // network
        bind<OkHttpClient>() with singleton { Client().invoke()}
        bind<Retrofit>() with singleton { RetrofitBuilder(instance()).invoke() }
        bind<ApiInterface>() with singleton { CreateApiInterface(instance()).invoke() }

        // viewModel factories
        bind() from provider { MainPageViewModelFactory(instance()) }
        bind() from provider { MovieDetailsViewModelFactory(instance()) }
        bind() from provider { TvDetailsViewModelFactory(instance()) }
        bind() from provider { SplashScreenViewModelFactory()}
        bind() from provider { PlayVideoViewModelFactory()}
        bind() from provider { TopMoviesViewModelFactory(instance()) }


        // repositories
        bind() from singleton { DataRepository(instance()) }

    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }


}