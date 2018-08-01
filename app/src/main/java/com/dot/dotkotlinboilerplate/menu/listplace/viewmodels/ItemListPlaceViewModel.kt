package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.databinding.ObservableField
import android.view.View
import com.dot.dotkotlinboilerplate.menu.listplace.AdapterOnClickListener
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel

class ItemListPlaceViewModel(private val model: ListPlaceModel, private val adapterOnClickListener: AdapterOnClickListener) {

    var title: ObservableField<String?> = ObservableField(model.name)
    var location: ObservableField<String?> = ObservableField(model.location)
    var imageUrl: ObservableField<String?> = ObservableField(model.image)

    fun clickItemListPlace(view: View){
        adapterOnClickListener.onItemClickListener(model)
    }

}