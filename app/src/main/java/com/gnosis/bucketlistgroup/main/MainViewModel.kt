package com.gnosis.bucketlistgroup.main

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gnosis.bucketlistgroup.data.api.WishesApi
import com.gnosis.bucketlistgroup.data.db.WishesRepository
import com.gnosis.bucketlistgroup.util.RxBus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    var wishesRepository: WishesRepository,
    var rxBus: RxBus,
    var wishesApi: WishesApi
): ViewModel() {

    suspend fun loadMyBucketList() = withContext(Dispatchers.IO) {
        //Code for loading from API the list
        try {
            val whises = wishesApi.getAll().body()
            Log.d("Hilt app", "Get wishes - ${whises?.size}")
            whises?.let {
                wishesRepository.insertAll(whises)
            }
        } catch (ex: Exception) {
            Log.e("App", ex.toString())
        }


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