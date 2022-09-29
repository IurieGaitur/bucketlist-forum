package com.gnosis.bucketlistgroup.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Wish::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wishesDao(): WishesDao
}
