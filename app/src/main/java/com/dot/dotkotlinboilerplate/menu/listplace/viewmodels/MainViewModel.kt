package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.dot.dotkotlinboilerplate.menu.listplace.repositories.ListPlaceRepository
import com.dot.dotkotlinboilerplate.networks.ListPlaceResponse

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {

    private lateinit var listPlaceRepository: ListPlaceRepository

    private val listPlaceResponse = ListPlaceResponse()
    private val compositeDisposable = CompositeDisposable()

    var isLoading: ObservableField<Boolean>  = ObservableField()

    fun setListPlaceRepository(listPlaceRepository: ListPlaceRepository){
        this.listPlaceRepository = listPlaceRepository
    }

    fun requestListPlace(){
        isLoading.set(true)
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            listPlaceRepository.onGetListPlaceSuccess(it)
                        },
                        onError = {
                            listPlaceRepository.onGetListPlaceError()
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