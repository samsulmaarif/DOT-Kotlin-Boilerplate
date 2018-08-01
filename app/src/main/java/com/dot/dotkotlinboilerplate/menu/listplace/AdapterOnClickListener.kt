package com.dot.dotkotlinboilerplate.menu.listplace

import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceResponseModel

interface AdapterOnClickListener {
    fun onItemClickListener(listPlaceModel: ListPlaceResponseModel.ListPlaceModel)
}