package com.videostreamshows.ui.fragment.movieDetails

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.transition.Slide
import androidx.transition.TransitionInflater
import com.google.android.material.transition.MaterialContainerTransform
import com.haroldadmin.cnradapter.NetworkResponse
import com.videostreamshows.R
import com.videostreamshows.data.remote.model.Cast
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.databinding.FragmentMovieDetailsBinding
import com.videostreamshows.ui.adapter.imageSlider.ImageSliderAdapter
import com.videostreamshows.ui.adapter.recyclerView.RecyclerAdapter
import com.videostreamshows.ui.base.ScopedFragment
import com.videostreamshows.ui.utils.OnClickHandler
import com.videostreamshows.ui.utils.OnDataUpdate
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MovieDetailsFragment : ScopedFragment() , KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: MovieDetailsViewModelFactory by instance()

    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var binding: FragmentMovieDetailsBinding

    // -- FOR DATA
    private lateinit var movieId: String
    private lateinit var poster: String

    private val castsRvAdapter: RecyclerAdapter<Cast> by lazy {
        RecyclerAdapter<Cast>()
    }
    private val similarMovieRvAdapter: RecyclerAdapter<Movie> by lazy {
        RecyclerAdapter<Movie>()
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater , container , false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this , viewModelFactory).get(MovieDetailsViewModel::class.java)
        movieId = arguments?.let {  MovieDetailsFragmentArgs.fromBundle(it).movieId}.toString()
        poster = arguments?.let {  MovieDetailsFragmentArgs.fromBundle(it).poster}.toString()
        bindUI()
        bindAdapter()
        uiActions()
        initUIActions()
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.main_fra
            duration = 700.toLong()
            scrimColor = Color.TRANSPARENT
            startView = activity?.findViewById(R.id.item_movie_img)
            endView = binding.fraMovieDetailsPoster
            containerColor = activity?.getColor(R.color.colorPrimary)!!
            setAllContainerColors(R.color.browser_actions_title_color.toInt())
        }
        returnTransition = Slide().apply {
            duration = 700L
            addTarget(R.id.item_movie_img)
        }
    }

    private fun bindUI() = launch {
        binding.poster = poster
        binding.loading = true

        when(val callback = viewModel.movieDetail(movieId)){
            is NetworkResponse.Success ->{
                binding.movie = callback.body
                binding.loading = false
            }

        }
        when(val callback = viewModel.movieCredits(movieId)){
            is NetworkResponse.Success -> {
                castsRvAdapter.datas = callback.body.cast
            }
        }
        when(val callback = viewModel.similarMovies(movieId)){
            is NetworkResponse.Success ->{
                similarMovieRvAdapter.datas = callback.body.results
            }
        }
    }
    private fun bindAdapter(){
        binding.apply {
            fraMovieDetailsRvCasts.adapter = castsRvAdapter
            fraMovieDetailsRvSimMov.adapter = similarMovieRvAdapter
        }
    }
    private fun initUIActions(){
        castsRvAdapter.onDataUpdate = object : OnDataUpdate {
            override fun dataUpdated() {
                binding.fraMovieDetailsCastsProgress.visibility = View.GONE
            }
        }

        similarMovieRvAdapter.onDataUpdate = object : OnDataUpdate {
            override fun dataUpdated() {
                binding.fraMovieDetailsSimMovProgress.visibility = View.GONE
            }
        }

    }
    private fun uiActions(){
        binding.onClickHandler = object : OnClickHandler<Nothing> {
            override fun onClickItem(element: Nothing) {}
            override fun onClickView(view: View, element: Nothing) {}
            override fun onClick(view: View) {
                findNavController().navigate(R.id.action_movieDetailsFragment_to_playVideoFragment)
            }
        }
    }



}