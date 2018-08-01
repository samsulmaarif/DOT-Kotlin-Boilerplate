package com.dot.dotkotlinboilerplate.networks

import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("Sample.json")
    fun getListPlace(): Observable<ListPlaceResponseModel>
}