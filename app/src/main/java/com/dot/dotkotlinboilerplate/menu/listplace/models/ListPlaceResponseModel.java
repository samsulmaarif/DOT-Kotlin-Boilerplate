package com.dot.dotkotlinboilerplate.menu.listplace.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListPlaceResponseModel implements Parcelable {

    @SerializedName("status_code") @Expose public Integer statusCode;
    @SerializedName("data") @Expose public List<ListPlaceModel> data = new ArrayList<>();

    protected ListPlaceResponseModel(Parcel in) {
        this.statusCode = in.readInt();
        in.readList(data, ListPlaceModel.class.getClassLoader());
    }

    public static final Creator<ListPlaceResponseModel> CREATOR = new Creator<ListPlaceResponseModel>() {
        @Override
        public ListPlaceResponseModel createFromParcel(Parcel in) {
            return new ListPlaceResponseModel(in);
        }

        @Override
        public ListPlaceResponseModel[] newArray(int size) {
            return new ListPlaceResponseModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.statusCode);
        parcel.writeList(this.data);
    }
}
