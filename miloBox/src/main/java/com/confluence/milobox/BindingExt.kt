package com.confluence.milobox

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    imageUrl?.let {
        Glide.with(context)
            .load(imageUrl)
            .into(this)
    }
}
@BindingAdapter("imageCircularUrl")
fun ImageView.setImageCircularUrl(imageUrl: String?) {
    imageUrl?.let {
        Glide.with(context)
            .load(imageUrl)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(this)
    }
}