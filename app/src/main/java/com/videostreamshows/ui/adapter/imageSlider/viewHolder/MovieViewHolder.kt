package com.videostreamshows.ui.adapter.imageSlider.viewHolder

import com.smarteist.autoimageslider.SliderViewAdapter
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.databinding.RowImageSliderBinding
import com.videostreamshows.ui.utils.OnClickHandler

class MovieViewHolder(
    private val itemBinding: RowImageSliderBinding
): SliderViewAdapter.ViewHolder(itemBinding.root){
    fun <T> bind(item: Movie, onClickHandler: OnClickHandler<T>?){
        itemBinding.movie = item
        onClickHandler?.let{
            itemBinding.onClickHandler = onClickHandler
        }
    }
}