package com.dot.dotkotlinboilerplate.menu.listplace.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListPlaceModel(

        @SerializedName("status_code") @Expose val statusCode: Int?,
        @SerializedName("data") @Expose val data: MutableList<ListPlace>?){

    class ListPlace(
            @SerializedName("name") @Expose val name: String?,
            @SerializedName("location") @Expose val location: String?,
            @SerializedName("image") @Expose val image: String?
    )

}