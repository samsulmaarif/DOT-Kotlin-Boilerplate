package com.dot.dotkotlinboilerplate.menu.listplace

import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel

interface AdapterOnClickListener {
    fun onItemClickListener(listPlaceModel: ListPlaceModel)
}