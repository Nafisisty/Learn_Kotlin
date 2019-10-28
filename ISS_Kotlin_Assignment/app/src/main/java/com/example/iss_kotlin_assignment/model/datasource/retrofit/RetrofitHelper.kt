package com.example.iss_kotlin_assignment.model.datasource.retrofit

import com.example.iss_kotlin_assignment.model.Constants.Companion.BASE_URL
import com.example.iss_kotlin_assignment.model.Constants.Companion.PATH
import com.example.iss_kotlin_assignment.model.Constants.Companion.QUERY_RESULTS
import com.example.iss_kotlin_assignment.model.Constants.Companion.QUERY_RESULTS2
import com.example.iss_kotlin_assignment.model.datasource.okhttp.OkHttpHelper
import com.example.iss_kotlin_assignment.model.iss.ISS
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitHelper {
    companion object{
        fun createRetrofit(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHelper.getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        }

        fun getObservable(userlat: String,userlon: String): Observable<ISS> {
            val retrofit = createRetrofit()
            val remoteService = retrofit.create(RemoteService::class.java)
            return remoteService.getISSObservable(userlat, userlon)
        }
    }

    interface RemoteService {

        @GET(PATH)
        fun getISSObservable(@Query(QUERY_RESULTS) lat: String,
                             @Query(QUERY_RESULTS2) lon: String): Observable<ISS>

    }
}