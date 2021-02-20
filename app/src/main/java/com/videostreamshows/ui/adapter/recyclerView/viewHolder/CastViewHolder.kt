package com.videostreamshows.ui.adapter.recyclerView.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.videostreamshows.data.remote.model.Cast
import com.videostreamshows.data.remote.model.Tv
import com.videostreamshows.databinding.RowCastBinding
import com.videostreamshows.databinding.RowTvBinding
import com.videostreamshows.ui.utils.OnClickHandler

class CastViewHolder(
    private val itemBinding: RowCastBinding
): RecyclerView.ViewHolder(itemBinding.root){
    fun <T> bind(item: Cast, onClickHandler: OnClickHandler<T>?){
        itemBinding.cast = item
        onClickHandler?.let{
            itemBinding.onClickHandler = onClickHandler
        }
    }
}