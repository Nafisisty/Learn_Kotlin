package com.example.iss_kotlin_assignment.model.datasource.rxjava

import com.example.iss_kotlin_assignment.model.datasource.retrofit.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DataSourceRepo {

    fun getISS(callback: Callback) {

        RetrofitHelper.getObservable("33.901760", "-84.477783")
            .subscribeOn(Schedulers.io())
            .retryWhen { o -> o.take(5).delay(2, TimeUnit.SECONDS) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(ISSResponseObserver(callback))
    }

}