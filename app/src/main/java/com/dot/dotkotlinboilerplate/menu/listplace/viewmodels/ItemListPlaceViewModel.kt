package com.dot.dotkotlinboilerplate.menu.listplace.viewmodels

import android.databinding.ObservableField
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel

class ItemListPlaceViewModel(model: ListPlaceModel.ListPlace) {

    var title: ObservableField<String?> = ObservableField(model.name)
    var location: ObservableField<String?> = ObservableField(model.location)
    var imageUrl: ObservableField<String?> = ObservableField(model.image)

}