package com.videostreamshows.ui.utils

import android.view.View

interface OnClickHandler<T>{
    fun onClickItem(element: T)
    fun onClick(view: View)
    fun onClickView(view: View , element: T)
}