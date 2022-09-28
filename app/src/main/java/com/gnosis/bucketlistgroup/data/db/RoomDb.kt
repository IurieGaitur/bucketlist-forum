package com.gnosis.bucketlistgroup.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

const val DATABASE_NAME = "test-db"

class RoomDB(context: Context) {
    val appDatabase: AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .addCallback(object : RoomDatabase.Callback() {
        })
        .allowMainThreadQueries()
        .build()
}