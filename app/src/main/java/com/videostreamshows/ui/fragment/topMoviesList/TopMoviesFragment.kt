package com.videostreamshows.ui.fragment.topMoviesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import com.videostreamshows.R
import com.videostreamshows.data.remote.model.NetworkState
import com.videostreamshows.databinding.FragmentTopMoviesBinding
import com.videostreamshows.ui.adapter.paging.RecyclerAdapter
import com.videostreamshows.ui.base.ScopedFragment
import com.videostreamshows.ui.utils.OnClickHandler
import kotlinx.android.synthetic.main.fragment_top_movies.*
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class TopMoviesFragment : ScopedFragment() , KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: TopMoviesViewModelFactory by instance()

    private lateinit var viewModel: TopMoviesViewModel
    private lateinit var binding: FragmentTopMoviesBinding

    // -- FOR DATA
    private lateinit var adapter : RecyclerAdapter<Any>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentTopMoviesBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this , viewModelFactory).get(TopMoviesViewModel::class.java)
        fra_top_movies_rv.layoutAnimation = AnimationUtils.loadLayoutAnimation(requireContext() , R.anim.layout_animation_fall_down)
        fra_top_movies_rv.scheduleLayoutAnimation()
        configureObservables()
        configureRecyclerView()
        bindUI()
    }
    private fun bindUI() = launch{

    }

    fun setQuery(query: String?){
        Toast.makeText(requireContext() , "$query" , Toast.LENGTH_SHORT).show()
        configViewModel("$query")
    }
    override fun onStart() {
        super.onStart()
        viewModel.refreshAllList()
    }
    private fun configureRecyclerView() {
        // show items rv
        adapter = RecyclerAdapter(object : RecyclerAdapter.OnClickListener{
            override fun onRefresh() {

            }

            override fun whenListIsUpdated(size: Int, networkState: NetworkState?) {
                updateUIWhenLoading(size , networkState)
            }

        })

        adapter.onClickHandler =
            object : OnClickHandler<Any> {
                override fun onClickView(view: View, element: Any) {}
                override fun onClickItem(element: Any) {}
                override fun onClick(view: View) {
                }
            }

        binding.fraTopMoviesRv.adapter = adapter
    }

    private fun configureObservables() {
        viewModel.networkState?.observe(viewLifecycleOwner, Observer { adapter.updateNetworkState(it) })
        viewModel.users.observe(viewLifecycleOwner, Observer { adapter.submitList(it as PagedList<Any>) })
    }

    private fun configViewModel(bundle:String){
        viewModel.fetchQuery(bundle)
    }

    private fun updateUIWhenLoading(size:Int , networkState: NetworkState?){
        fra_top_movies_progress.visibility = if(size == 0 && networkState == NetworkState.RUNNING) View.VISIBLE else View.GONE
    }
}