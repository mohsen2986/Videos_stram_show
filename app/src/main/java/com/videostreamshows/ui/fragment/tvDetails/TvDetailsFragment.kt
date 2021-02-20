package com.videostreamshows.ui.fragment.tvDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.haroldadmin.cnradapter.NetworkResponse
import com.videostreamshows.R
import com.videostreamshows.data.remote.model.Cast
import com.videostreamshows.data.remote.model.Season
import com.videostreamshows.databinding.FragmentTvDetailsBinding
import com.videostreamshows.ui.adapter.recyclerView.RecyclerAdapter
import com.videostreamshows.ui.base.ScopedFragment
import com.videostreamshows.ui.fragment.movieDetails.MovieDetailsFragmentArgs
import com.videostreamshows.ui.fragment.movieDetails.MovieDetailsFragmentArgs.Companion.fromBundle
import com.videostreamshows.ui.fragment.playVideo.PlayVideoViewModelFactory
import com.videostreamshows.ui.fragment.tvDetails.TvDetailsFragmentArgs.Companion.fromBundle
import com.videostreamshows.ui.utils.OnClickHandler
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import javax.annotation.meta.When

class TvDetailsFragment : ScopedFragment() , KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: TvDetailsViewModelFactory by instance()

    private lateinit var viewModel: TvDetailsViewModel
    private lateinit var binding: FragmentTvDetailsBinding

    // -- FOR DATA
    private lateinit var tvId: String
    private val castsRvAdapter: RecyclerAdapter<Cast> by lazy {
        RecyclerAdapter<Cast>()
    }
    private val seasonsRvAdapter: RecyclerAdapter<Season> by lazy {
        RecyclerAdapter<Season>()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        binding = FragmentTvDetailsBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this , viewModelFactory).get(TvDetailsViewModel::class.java)
        tvId = arguments?.let {  TvDetailsFragmentArgs.fromBundle(it).tvId}.toString()
        bindUI()
        bindAdapters()
        uiActions()
    }
    private fun bindUI() = launch {
        binding.loading = true
        when(val callback = viewModel.tvDetails(tvId)){
            is NetworkResponse.Success ->{
                binding.tv = callback.body
                seasonsRvAdapter.datas = callback.body.seasons
                binding.loading = false
            }
            else -> Log.e("Log__" , "$callback")

        }
        when(val callback = viewModel.tvCredits(tvId)){
            is NetworkResponse.Success ->{
                castsRvAdapter.datas = callback.body.cast
            }
        }
    }
    private fun bindAdapters(){
        binding.apply {
            fraTvDetailsRvCasts.adapter  = castsRvAdapter
            fraTvDetailsRvSeasons.adapter = seasonsRvAdapter
        }
    }
    private fun uiActions(){
        binding.onClickHandler = object : OnClickHandler<Nothing> {
            override fun onClickItem(element: Nothing) {}
            override fun onClickView(view: View, element: Nothing) {}
            override fun onClick(view: View) {
                findNavController().navigate(R.id.action_tvDetailsFragment_to_playVideoFragment)
            }
        }
    }

}