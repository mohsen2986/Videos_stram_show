package com.videostreamshows.ui.adapter.recyclerView.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.data.remote.model.Tv
import com.videostreamshows.databinding.RowImageSliderBinding
import com.videostreamshows.databinding.RowMovieBinding
import com.videostreamshows.databinding.RowTvBinding
import com.videostreamshows.ui.adapter.recyclerView.RecyclerAdapter
import com.videostreamshows.ui.utils.OnClickHandler

class TvTrendingViewHolder(
        private val itemBinding: RowTvBinding
): RecyclerView.ViewHolder(itemBinding.root){
    fun <T> bind(item: Tv , onClickHandler: OnClickHandler<T>?){
        itemBinding.tv = item
        onClickHandler?.let{
            itemBinding.onClickHandler = onClickHandler
        }
    }
}