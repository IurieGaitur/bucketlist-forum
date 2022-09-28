package com.gnosis.bucketlistgroup.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Any app that uses Hilt needs to create App class and put this attribute

// List of a normal project dependencies
/*
1. Repository
2. Db
3. Api
4. Viewmodel
5. RxBus / Utils
6. GSON
7. SharedPref
8. Rx

 */
@HiltAndroidApp
class BucketListApp: Application() {
}