package com.gnosis.bucketlistgroup.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WishesDao {
    @Insert
    fun insert(wish: Wish)

    @Insert
    fun insertAll(wishes: List<Wish>)

    @Query("SELECT * from wish")
    suspend fun getAll(): List<Wish>
}