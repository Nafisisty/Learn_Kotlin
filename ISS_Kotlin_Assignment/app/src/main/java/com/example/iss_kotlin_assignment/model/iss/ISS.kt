package com.example.iss_kotlin_assignment.model.iss

import android.os.Parcel
import android.os.Parcelable

data class ISS(var message: String? = "", var request: Request = Request(), var response: List<Response> = emptyList()) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        TODO("request"),
        TODO("response")
    ) {
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<ISS> {
        override fun createFromParcel(parcel: Parcel): ISS {
            return ISS(parcel)
        }

        override fun newArray(size: Int): Array<ISS?> {
            return arrayOfNulls(size)
        }
    }
}
