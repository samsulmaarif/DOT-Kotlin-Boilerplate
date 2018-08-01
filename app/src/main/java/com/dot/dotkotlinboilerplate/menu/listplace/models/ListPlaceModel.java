package com.dot.dotkotlinboilerplate.menu.listplace.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPlaceModel implements Parcelable {

    @SerializedName("name") @Expose public String name;
    @SerializedName("location") @Expose public String location;
    @SerializedName("image") public String image;

    protected ListPlaceModel(Parcel in) {
        this.name = in.readString();
        this.location = in.readString();
        this.image = in.readString();
    }

    public static final Creator<ListPlaceModel> CREATOR = new Creator<ListPlaceModel>() {
        @Override
        public ListPlaceModel createFromParcel(Parcel in) {
            return new ListPlaceModel(in);
        }

        @Override
        public ListPlaceModel[] newArray(int size) {
            return new ListPlaceModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.location);
        parcel.writeString(this.image);
    }
}
