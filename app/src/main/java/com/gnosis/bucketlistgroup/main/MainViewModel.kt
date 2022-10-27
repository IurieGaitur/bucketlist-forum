package com.gnosis.bucketlistgroup.main

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gnosis.bucketlistgroup.app.build.IoDispatcher
import com.gnosis.bucketlistgroup.data.api.WishesApi
import com.gnosis.bucketlistgroup.data.db.WishesRepository
import com.gnosis.bucketlistgroup.util.RxBus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    var wishesRepository: WishesRepository,
    var rxBus: RxBus,
    var wishesApi: WishesApi,
    @IoDispatcher var ioDispatcher: CoroutineDispatcher
): ViewModel() {

    suspend fun loadMyBucketList() = withContext(ioDispatcher) {
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

    suspend fun getAvailableWishes() = withContext(ioDispatcher) {
        return@withContext wishesRepository.getAll()
    }

    suspend fun addPublicWish()= withContext(ioDispatcher) {
        //Code for loading from API the list
    }

    suspend fun addToMyBucketList()= withContext(ioDispatcher) {
        //Code for loading from API the list
    }

    suspend fun completeToMyBucketList()= withContext(ioDispatcher) {
        //Code for loading from API the list
    }

    suspend fun removeFromMyBucketList()= withContext(ioDispatcher) {
        //Code for loading from API the list
    }
}