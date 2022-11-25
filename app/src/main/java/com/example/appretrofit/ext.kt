package com.example.appretrofit

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String) {

    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher))
        .centerCrop().into(this)
}