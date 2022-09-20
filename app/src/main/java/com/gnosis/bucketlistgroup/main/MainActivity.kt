package com.gnosis.bucketlistgroup.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gnosis.bucketlistgroup.R
import dagger.hilt.android.AndroidEntryPoint

//This attribute is necessary for inserting dependencies into an android component: activity, fragment, service, view
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}