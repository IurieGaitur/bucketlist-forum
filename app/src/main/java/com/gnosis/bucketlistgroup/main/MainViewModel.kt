package com.gnosis.bucketlistgroup.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltViewModel
class MainViewModel: ViewModel() {

    suspend fun loadMyBucketList() = withContext(Dispatchers.IO) {
        //Code for loading from API the list
    }

    suspend fun getAvailableWishes() = withContext(Dispatchers.IO) {
        //Code for loading from API the list
    }

    suspend fun addPublicWish()= withContext(Dispatchers.IO) {
        //Code for loading from API the list
    }

    suspend fun addToMyBucketList()= withContext(Dispatchers.IO) {
        //Code for loading from API the list
    }

    suspend fun completeToMyBucketList()= withContext(Dispatchers.IO) {
        //Code for loading from API the list
    }

    suspend fun removeFromMyBucketList()= withContext(Dispatchers.IO) {
        //Code for loading from API the list
    }



}