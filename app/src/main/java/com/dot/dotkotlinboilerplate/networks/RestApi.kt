package com.dot.dotkotlinboilerplate.networks

import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("Sample.json")
    fun getListPlace(): Observable<ListPlaceModel>
}