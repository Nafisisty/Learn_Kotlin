package com.example.iss_kotlin_assignment.view.activities.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.iss_kotlin_assignment.R
import com.example.iss_kotlin_assignment.model.datasource.rxjava.Callback
import com.example.iss_kotlin_assignment.model.datasource.rxjava.DataSourceRepo
import com.example.iss_kotlin_assignment.model.iss.ISS

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataSourceRepo = DataSourceRepo()
        dataSourceRepo.getISS(object : Callback {
            override fun onSuccess(iss: ISS) {
                Log.d("TAG", "onSuccess: ${iss.message}")
            }
        })
    }
}
