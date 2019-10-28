package com.example.iss_kotlin_assignment.model.datasource.okhttp

import okhttp3.OkHttpClient

class OkHttpHelper {
    companion object{
        fun getOkHttp(): OkHttpClient {
            return OkHttpClient.Builder().build()
        }
    }
}