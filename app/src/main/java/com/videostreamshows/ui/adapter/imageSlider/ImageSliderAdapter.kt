package com.videostreamshows.ui.adapter.imageSlider

import android.view.LayoutInflater
import android.view.ViewGroup
import com.videostreamshows.ui.utils.OnClickHandler
import com.smarteist.autoimageslider.SliderViewAdapter
import com.videostreamshows.R
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.databinding.RowImageSliderBinding
import com.videostreamshows.ui.adapter.imageSlider.viewHolder.MovieViewHolder

class ImageSliderAdapter<T>()
    :SliderViewAdapter<SliderViewAdapter.ViewHolder>(){

    var datas:List<T> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    var onClick: OnClickHandler<T>?= null
    lateinit var layoutInflater:LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        layoutInflater = LayoutInflater.from(parent?.context)
        return when(getType()){
            R.layout.row_image_slider ->
                MovieViewHolder(
                    RowImageSliderBinding.inflate(layoutInflater , parent , false)
                )
            else -> throw IllegalArgumentException("unknown view type:")
        }
    }

    override fun getCount(): Int = datas.size

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        when(viewHolder) {
            is MovieViewHolder ->
                viewHolder.bind(datas[position] as Movie, onClickHandler = onClick)
        }

    }
    private fun getType(): Int =
        if(datas[0] is Movie)
            R.layout.row_image_slider
        else
            -1
}

