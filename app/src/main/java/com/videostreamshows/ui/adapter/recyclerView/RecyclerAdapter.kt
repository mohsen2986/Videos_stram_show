package com.videostreamshows.ui.adapter.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.videostreamshows.R
import com.videostreamshows.data.remote.model.Cast
import com.videostreamshows.data.remote.model.Movie
import com.videostreamshows.data.remote.model.Season
import com.videostreamshows.data.remote.model.Tv
import com.videostreamshows.databinding.RowCastBinding
import com.videostreamshows.databinding.RowMovieBinding
import com.videostreamshows.databinding.RowSeasonBinding
import com.videostreamshows.databinding.RowTvBinding
import com.videostreamshows.ui.adapter.recyclerView.viewHolder.CastViewHolder
import com.videostreamshows.ui.adapter.recyclerView.viewHolder.MovieTrendingViewHolder
import com.videostreamshows.ui.adapter.recyclerView.viewHolder.SeasonViewHolder
import com.videostreamshows.ui.adapter.recyclerView.viewHolder.TvTrendingViewHolder
import com.videostreamshows.ui.utils.OnClickHandler
import com.videostreamshows.ui.utils.OnDataUpdate

class RecyclerAdapter<T>(
):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var isGrid = false
    var onClickHandler: OnClickHandler<T> ?= null
    var onDataUpdate: OnDataUpdate ?= null
    var datas: List<T> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
        onDataUpdate?.let { onDataUpdate -> onDataUpdate.dataUpdated() }
    }
    private lateinit var layoutInflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            R.layout.row_movie ->
                MovieTrendingViewHolder(
                        RowMovieBinding.inflate(layoutInflater , parent , false)
                )
            R.layout.row_tv ->
                TvTrendingViewHolder(
                        RowTvBinding.inflate(layoutInflater , parent , false)
                )
            R.layout.row_cast ->
                CastViewHolder(
                    RowCastBinding.inflate(layoutInflater , parent , false)
                )
            R.layout.row_season ->
                SeasonViewHolder(
                        RowSeasonBinding.inflate(layoutInflater , parent , false)
                )

            else -> throw IllegalStateException("the type is invalid!!")
        }
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MovieTrendingViewHolder ->
                holder.bind(datas[position] as Movie , onClickHandler = onClickHandler)

            is TvTrendingViewHolder ->
                holder.bind(datas[position] as Tv , onClickHandler = onClickHandler)

            is CastViewHolder ->
                holder.bind(datas[position] as Cast , onClickHandler = onClickHandler)

            is SeasonViewHolder ->
                holder.bind(datas[position] as Season , onClickHandler = onClickHandler)
        }
    }

    override fun getItemViewType(position: Int): Int =
            when(datas[0]){
                is Movie -> R.layout.row_movie
                is Tv    -> R.layout.row_tv
                is Cast  -> R.layout.row_cast
                is Season-> R.layout.row_season
                else -> throw IllegalStateException("the type is invalid!")
            }
}