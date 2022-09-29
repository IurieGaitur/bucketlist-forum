package com.gnosis.bucketlistgroup.data.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface WishesDao {
    @Insert
    fun insert(wish: Wish)

    @Insert
    fun insertAll(wishes: List<Wish>)
}