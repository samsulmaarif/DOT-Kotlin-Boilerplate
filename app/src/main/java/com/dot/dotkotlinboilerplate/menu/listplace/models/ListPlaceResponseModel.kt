package com.dot.dotkotlinboilerplate.menu.listplace.models

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListPlaceResponseModel(
        @SerializedName("status_code") @Expose var statusCode: Int,
        @SerializedName("data") @Expose var data: MutableList<ListPlaceModel>
): Parcelable
