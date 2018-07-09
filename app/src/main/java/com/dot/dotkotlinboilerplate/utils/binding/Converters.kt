package com.dot.dotkotlinboilerplate.utils.binding

import android.animation.Animator
import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.ProgressBar
import com.bumptech.glide.GenericTransitionOptions
import com.dot.dotkotlinboilerplate.data.AppConstants

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

        @JvmStatic
        @BindingAdapter("bind:showRecycler")
        fun showRecycler(recyclerView: RecyclerView, hide: Boolean){
            if(hide) {
                recyclerView.alpha = 0f
                recyclerView.animate().alpha(1f).duration = AppConstants.GLOBAL_ANIM_DURATION
            }
        }

        @JvmStatic
        @BindingAdapter("bind:hideProgressBar")
        fun hideProgressBar(progressBar: ProgressBar, hide: Boolean){
            if (hide) {
                progressBar.visibility = View.VISIBLE
                progressBar.alpha = 1f
            } else {
                progressBar.animate().alpha(0f).setDuration(AppConstants.GLOBAL_ANIM_DURATION).setListener(object : Animator.AnimatorListener {

                    override fun onAnimationRepeat(p0: Animator?) {

                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        progressBar.visibility = View.INVISIBLE
                    }

                    override fun onAnimationStart(p0: Animator?) {

                    }

                    override fun onAnimationCancel(p0: Animator?) {

                    }

                })
            }
        }

    }

}
