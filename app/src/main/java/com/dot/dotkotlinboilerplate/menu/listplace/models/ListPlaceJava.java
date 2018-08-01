package com.dot.dotkotlinboilerplate.menu.listplace.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPlaceJava implements Parcelable {

    @SerializedName("name") @Expose public String name;
    @SerializedName("location") @Expose public String location;
    @SerializedName("image") public String image;

    protected ListPlaceJava(Parcel in) {
        this.name = in.readString();
        this.location = in.readString();
        this.image = in.readString();
    }

    public static final Creator<ListPlaceJava> CREATOR = new Creator<ListPlaceJava>() {
        @Override
        public ListPlaceJava createFromParcel(Parcel in) {
            return new ListPlaceJava(in);
        }

        @Override
        public ListPlaceJava[] newArray(int size) {
            return new ListPlaceJava[size];
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
