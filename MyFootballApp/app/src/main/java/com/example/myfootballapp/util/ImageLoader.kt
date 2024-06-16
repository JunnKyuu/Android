package com.example.myfootballapp.util

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoader {
    fun loadImage(context: Context, url: String?, imageView: ImageView) {
        if (url != null) {
            Picasso.get().load(url).into(imageView)
        }
    }
}
