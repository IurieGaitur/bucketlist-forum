package com.gnosis.bucketlistgroup.data.db

import android.util.Log
import com.gnosis.bucketlistgroup.util.RxSchedulers

class WishesRepository(val db: AppDatabase, val rxSchedulers: RxSchedulers) {

    fun insertWish(wish: Wish) {
        db.wishesDao().insert(wish)
    }

    fun insertAll(wishes: List<Wish>) {
        Log.d("Hilt app", "Save wishes locally")
        //db.wishesDao().insertAll(wishes)
    }

    suspend fun getAll(): List<Wish> {
        return  db.wishesDao().getAll()
    }
}