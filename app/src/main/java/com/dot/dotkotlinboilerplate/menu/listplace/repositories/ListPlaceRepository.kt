package com.dot.dotkotlinboilerplate.menu.listplace.repositories

import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel

interface ListPlaceRepository {
    fun onGetListPlaceSuccess(listPlaceModel: ListPlaceModel)
    fun onGetListPlaceError()
}