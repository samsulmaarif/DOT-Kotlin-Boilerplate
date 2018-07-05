package com.dot.dotkotlinboilerplate.networks

import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel
import io.reactivex.Observable

class ListPlaceResponse {

    private val apiService = ServiceFactory.create()

    fun getListPlace(): Observable<ListPlaceModel>{
        return apiService.getListPlace()
    }

}