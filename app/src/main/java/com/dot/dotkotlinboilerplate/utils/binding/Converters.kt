package com.dot.dotkotlinboilerplate.utils.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import com.bumptech.glide.GenericTransitionOptions

import com.dot.dotkotlinboilerplate.utils.glide.GlideApp

class Converters {

    companion object {
        @JvmStatic
        @BindingAdapter("bind:loadImage")
        fun loadImage(imageView: AppCompatImageView, imageUrl: String) {
            GlideApp.with(imageView.context.applicationContext)
                    .load(imageUrl)
                    .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
                    .into(imageView)
        }
    }

}
