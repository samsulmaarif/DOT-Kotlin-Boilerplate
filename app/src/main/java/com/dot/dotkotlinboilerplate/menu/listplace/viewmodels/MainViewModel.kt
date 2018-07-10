package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import com.dot.dotkotlinboilerplate.data.AppConstants
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel
import com.dot.dotkotlinboilerplate.networks.ListPlaceResponse

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {

    private val listPlaceResponse = ListPlaceResponse()
    private val compositeDisposable = CompositeDisposable()

    var isLoading: ObservableField<Boolean>  = ObservableField()
    var listData: MutableLiveData<ListPlaceModel> = MutableLiveData()

    fun requestListPlace(){
        isLoading.set(true)
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            listData.value = it
                        },
                        onError = {
                            it.printStackTrace()
                            Log.e(AppConstants.TAG_ERROR,"MainViewModel # error requestListPlace ${it.message}")
                        },
                        onComplete = {
                            isLoading.set(false)
                        }
                )
        )
    }

    fun destroy(){
        compositeDisposable.clear()
    }

}