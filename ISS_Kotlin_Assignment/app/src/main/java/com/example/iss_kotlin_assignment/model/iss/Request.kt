package com.example.iss_kotlin_assignment.model.iss

import android.os.Parcel
import android.os.Parcelable

data class Request (var altitude: Int = 0, var datetime: Int = 0, var latitude: Float = 0.0F, var longitude: Float = 0.0F, var passes: Int = 0) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(altitude)
        parcel.writeInt(datetime)
        parcel.writeFloat(latitude)
        parcel.writeFloat(longitude)
        parcel.writeInt(passes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Request> {
        override fun createFromParcel(parcel: Parcel): Request {
            return Request(parcel)
        }

        override fun newArray(size: Int): Array<Request?> {
            return arrayOfNulls(size)
        }
    }
}