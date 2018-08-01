package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceResponseModel
import com.dot.dotkotlinboilerplate.networks.ListPlaceResponse

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val listPlaceResponse = ListPlaceResponse()
    private val compositeDisposable = CompositeDisposable()

    var isLoading: ObservableField<Boolean>  = ObservableField()
    var listDataResponse: MutableLiveData<ListPlaceResponseModel> = MutableLiveData()

    fun requestListPlace(){
        isLoading.set(true)
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                                isLoading.set(false)
                                listDataResponse.value = it
                            },
                            {
                                isLoading.set(false)
                                it.printStackTrace()
                            }
                    )
        )
    }

    fun destroy(){
        compositeDisposable.clear()
    }

}