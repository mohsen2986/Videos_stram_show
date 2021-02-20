package com.videostreamshows.ui.adapter.paging

import androidx.recyclerview.widget.RecyclerView
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.databinding.RowMoviePagingBinding
import com.videostreamshows.ui.utils.OnClickHandler


class MovieViewHolder(
    private val itemViewBinding: RowMoviePagingBinding
):RecyclerView.ViewHolder(itemViewBinding.root){

    fun<T> bind(item :Movie ,onClick: OnClickHandler<T>?){
        itemViewBinding.movie = item
        onClick?.let {
            itemViewBinding.onClickHandler = onClick
        }
    }
}