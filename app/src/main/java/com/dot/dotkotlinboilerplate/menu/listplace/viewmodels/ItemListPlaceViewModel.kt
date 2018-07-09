package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.databinding.ObservableField
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel

class ItemListPlaceViewModel {

    var title: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()
    var imageUrl: ObservableField<String> = ObservableField();

    fun setupData(model: ListPlaceModel.ListPlace){
        title.set(model.name)
        location.set(model.location)
        imageUrl.set(model.image)
    }
}