package com.gnosis.bucketlistgroup.data.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)
}