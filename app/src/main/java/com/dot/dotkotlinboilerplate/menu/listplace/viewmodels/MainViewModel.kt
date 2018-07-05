package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.app.Activity
import com.dot.dotkotlinboilerplate.networks.ListPlaceResponse

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(activity: Activity) {

    private val listPlaceResponse = ListPlaceResponse()


    fun requestListPlace(){
        listPlaceResponse.getListPlace()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                })
    }

}