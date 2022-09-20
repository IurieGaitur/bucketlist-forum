package com.gnosis.bucketlistgroup

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Any app that uses Hilt needs to create App class and put this attribute
@HiltAndroidApp
class BucketListApp: Application() {
}