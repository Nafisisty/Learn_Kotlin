package com.example.iss_kotlin_assignment.model.datasource.rxjava

import com.example.iss_kotlin_assignment.model.iss.ISS

interface Callback {
    fun onSuccess(iss: ISS)
}