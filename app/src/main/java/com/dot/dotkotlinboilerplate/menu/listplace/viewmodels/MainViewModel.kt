package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.databinding.ObservableField
import com.dot.dotkotlinboilerplate.menu.listplace.repositories.ListPlaceRepository
import com.dot.dotkotlinboilerplate.networks.ListPlaceResponse

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val listPlaceRepository: ListPlaceRepository) {

    private val listPlaceResponse = ListPlaceResponse()
    private val compositeDisposable = CompositeDisposable()

    public var isLoading: ObservableField<Boolean>  = ObservableField()

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