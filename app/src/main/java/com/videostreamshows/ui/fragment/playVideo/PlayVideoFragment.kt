package com.videostreamshows.ui.fragment.playVideo

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.videostreamshows.R
import com.videostreamshows.databinding.FragmentPlayVideoBinding
import com.videostreamshows.ui.base.ScopedFragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class PlayVideoFragment : ScopedFragment() , KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: PlayVideoViewModelFactory by instance()

    private lateinit var viewModel: PlayVideoViewModel
    private lateinit var binding: FragmentPlayVideoBinding

    // --FOR DATA
    private lateinit var playerView: PlayerView
    private lateinit var simpleExoPlayer: SimpleExoPlayer

    private val URL = "https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentPlayVideoBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this , viewModelFactory).get(PlayVideoViewModel::class.java)
        initPlayer()

    }
    private fun initPlayer(){
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(requireContext())
        binding.fraPlayVideoExo.player = simpleExoPlayer
        val dataSource =  DefaultDataSourceFactory(requireContext() , Util.getUserAgent(requireContext() , "appname"))
        val videoSource: ExtractorMediaSource = ExtractorMediaSource.Factory(dataSource).createMediaSource(Uri.parse(URL))
        simpleExoPlayer.prepare(videoSource)
        simpleExoPlayer.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        simpleExoPlayer.release()
    }

}