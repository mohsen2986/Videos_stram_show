package com.videostreamshows.ui.fragment.mainPage

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialElevationScale
import com.haroldadmin.cnradapter.NetworkResponse
import com.videostreamshows.R
import com.videostreamshows.data.remote.model.Genre
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.data.remote.model.Tv
import com.videostreamshows.databinding.FragmentMainPageBinding
import com.videostreamshows.ui.adapter.imageSlider.ImageSliderAdapter
import com.videostreamshows.ui.adapter.recyclerView.RecyclerAdapter
import com.videostreamshows.ui.base.ScopedFragment
import com.videostreamshows.ui.utils.OnClickHandler
import com.videostreamshows.ui.utils.OnDataUpdate
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.android.synthetic.main.row_movie.*
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MainPageFragment : ScopedFragment() , KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: MainPageViewModelFactory by instance()

    private lateinit var viewModel: MainPageViewModel
    private lateinit var binding: FragmentMainPageBinding

    //-- FOR DATA
    private val imageSliderAdapter: ImageSliderAdapter<Movie> by lazy {
        ImageSliderAdapter<Movie>()
    }
    private val trendingMovieRvAdapter: RecyclerAdapter<Movie> by lazy {
        RecyclerAdapter<Movie>()
    }
    private val trendingTvRvAdapter: RecyclerAdapter<Tv> by lazy {
        RecyclerAdapter<Tv>()
    }
    private val genreMoviesRvAdapter: RecyclerAdapter<Movie> by lazy {
        RecyclerAdapter<Movie>()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater , container , false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this , viewModelFactory).get(MainPageViewModel::class.java)
        bindAdapter()
        initAdapterActions()
        bindUI()
        uiActions()
    }
    private fun bindUI() = launch {
        imageSliderAdapter.datas = viewModel.boarder().await()
        trendingMovieRvAdapter.datas = viewModel.topMovie().await()
        trendingTvRvAdapter.datas = viewModel.topTv().await()
        configTabLayout()
    }
    private fun uiActions(){
        binding.onClickHandler = object : OnClickHandler<Nothing> {
            override fun onClickItem(element: Nothing) {}
            override fun onClickView(view: View, element: Nothing) {}
            override fun onClick(view: View) {
                when(view.id){
                     R.id.fra_main_top_movies ->
                        findNavController().navigate(R.id.action_mainPageFragment_to_topMoviesFragment)
                }
            }

        }
    }
    private fun bindAdapter(){
        binding.apply {
            fraMainSlider.sliderAdapter = imageSliderAdapter
            fraMainRvMovieTrending.adapter = trendingMovieRvAdapter
            fraMainRvTvTrending.adapter = trendingTvRvAdapter
            fraMainRvGenreMovies.adapter = genreMoviesRvAdapter
        }
    }
    private fun initAdapterActions(){
        trendingMovieRvAdapter.onClickHandler = object : OnClickHandler<Movie> {
            override fun onClickItem(element: Movie) {}
            override fun onClick(view: View) {}
            override fun onClickView(view: View, element: Movie) {
                enterTransition = MaterialElevationScale(false).apply {
                    duration = 700.toLong()
                }
                returnTransition = MaterialElevationScale(false).apply {
                    duration = 700.toLong()
                }

                exitTransition = MaterialElevationScale(false).apply {
                    duration = 700.toLong()
                }
                reenterTransition = MaterialElevationScale(true).apply {
                    duration = 700.toLong()
                }
                findNavController()
                        .navigate(MainPageFragmentDirections.
                        actionMainPageFragmentToMovieDetailsFragment(element.id , element.posterPath) ,
                                FragmentNavigator.Extras.Builder()
                                .addSharedElements(
                                        mapOf(view  to "img")
                                ).build()
                        )
            }
        }
        trendingTvRvAdapter.onClickHandler = object : OnClickHandler<Tv> {
            override fun onClickItem(element: Tv) {}
            override fun onClick(view: View) {}
            override fun onClickView(view: View, element: Tv) {
                exitTransition = MaterialElevationScale(false).apply {
                    duration = 700.toLong()
                }
                reenterTransition = MaterialElevationScale(true).apply {
                    duration = 700.toLong()
                }
                findNavController()
                        .navigate(MainPageFragmentDirections.
                        actionMainPageFragmentToTvDetailsFragment(element.id.toString()))
            }
        }
        // loading status
        trendingMovieRvAdapter.onDataUpdate = object : OnDataUpdate {
            override fun dataUpdated() {
                binding.fraMainMovieProgress.visibility = View.GONE
            }
        }
        trendingTvRvAdapter.onDataUpdate = object : OnDataUpdate {
            override fun dataUpdated() {
                binding.fraMainTvProgress.visibility = View.GONE
            }
        }
        genreMoviesRvAdapter.onDataUpdate = object : OnDataUpdate {
            override fun dataUpdated() {
                binding.fraMainGenreProgress.visibility = View.GONE
            }
        }

    }
    private fun configTabLayout() = launch{
        viewModel.genres().await().forEach {
            binding.fraMainTabLayoutGenres.addTab(binding.fraMainTabLayoutGenres.newTab().setText(it.name))
        }.also {
            getSelectedGenreMovies(viewModel.genres().await()[0].name)
        }
        binding.fraMainTabLayoutGenres.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                getSelectedGenreMovies(tab?.text.toString())
            }

        })
    }
    private fun getSelectedGenreMovies(genre: String?) = launch {
        val selectedGenre = viewModel.genres().await().find { it.name == genre }!!
        binding.fraMainGenreProgress.visibility = View.VISIBLE
        when(val callback = viewModel.movieBasedOnGenre(selectedGenre.id.toString())){
            is NetworkResponse.Success ->{
                genreMoviesRvAdapter.datas = callback.body.results
            }
        }
    }
}