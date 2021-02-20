package com.videostreamshows.ui.adapter.recyclerView.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.data.remote.model.Season
import com.videostreamshows.databinding.RowMovieBinding
import com.videostreamshows.databinding.RowSeasonBinding
import com.videostreamshows.ui.utils.OnClickHandler

class SeasonViewHolder(
        private val itemBinding: RowSeasonBinding
): RecyclerView.ViewHolder(itemBinding.root){
    fun <T> bind(item: Season, onClickHandler: OnClickHandler<T>?){
        itemBinding.season = item
        onClickHandler?.let{
            itemBinding.onClickHandler = onClickHandler
        }
    }
}