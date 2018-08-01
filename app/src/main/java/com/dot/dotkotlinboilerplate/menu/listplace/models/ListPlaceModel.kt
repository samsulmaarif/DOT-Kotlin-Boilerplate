package com.dot.dotkotlinboilerplate.menu.listplace.models

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListPlaceModel(
        @SerializedName("name") @Expose  var name: String,
        @SerializedName("location") @Expose var location: String,
        @SerializedName("image") @Expose var image: String

): Parcelable
