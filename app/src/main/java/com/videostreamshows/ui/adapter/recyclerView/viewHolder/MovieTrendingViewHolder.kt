package com.videostreamshows.ui.adapter.recyclerView.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.databinding.RowImageSliderBinding
import com.videostreamshows.databinding.RowMovieBinding
import com.videostreamshows.ui.adapter.recyclerView.RecyclerAdapter
import com.videostreamshows.ui.utils.OnClickHandler

class MovieTrendingViewHolder(
        private val itemBinding: RowMovieBinding
): RecyclerView.ViewHolder(itemBinding.root){
    fun <T> bind(item: Movie , onClickHandler: OnClickHandler<T>?){
        itemBinding.movie = item
        onClickHandler?.let{
            itemBinding.onClickHandler = onClickHandler
        }
    }
}