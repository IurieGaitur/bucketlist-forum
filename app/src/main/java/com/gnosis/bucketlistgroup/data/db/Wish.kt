package com.gnosis.bucketlistgroup.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wish(@PrimaryKey val id: Int, val name: String)