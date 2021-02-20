package com.videostreamshows.ui.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.videostreamshows.R

class DataBindingUtils () {
companion object {
    @JvmStatic
    @BindingAdapter("android:loadImage")
    fun loadImage(imageView: ImageView, url: String?) {
        if(url != null)
            Glide
                .with(imageView.context)
                .load("https://www.themoviedb.org/t/p/original$url")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .transition(DrawableTransitionOptions.withCrossFade(400))
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.error_place_holder)
                .into(imageView)
    }
}
}