package com.dot.dotkotlinboilerplate.networks

import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceResponseModel
import io.reactivex.Observable

class ListPlaceResponse {

    private val apiService = ServiceFactory.create()

    fun getListPlace(): Observable<ListPlaceResponseModel>{
        return apiService.getListPlace()
    }

}