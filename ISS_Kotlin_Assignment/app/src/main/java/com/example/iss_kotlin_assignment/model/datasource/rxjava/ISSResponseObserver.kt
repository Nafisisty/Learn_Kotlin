package com.example.iss_kotlin_assignment.model.datasource.rxjava

import android.util.Log
import com.example.iss_kotlin_assignment.model.iss.ISS
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ISSResponseObserver(var callback: Callback) : Observer<ISS> {

    var iss = ISS()

    override fun onComplete() {

        callback.onSuccess(iss)

        Log.d("TAG", "Completed!!")

    }

    override fun onSubscribe(d: Disposable) {

        Log.d("TAG", "onSubscribe: SUBSCRIBING")

    }

    override fun onNext(iss: ISS) {

        this.iss = iss
        Log.d("TAG", "onNext: Getting Data")

    }

    override fun onError(e: Throwable) {

        Log.d("TAG", "onError: ", e)

    }
}