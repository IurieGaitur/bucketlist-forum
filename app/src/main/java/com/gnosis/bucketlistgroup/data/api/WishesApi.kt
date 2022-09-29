package com.gnosis.bucketlistgroup.data.api

import com.gnosis.bucketlistgroup.data.db.Wish
import retrofit2.http.GET

interface WishesApi {
    @GET("/wishes")
    fun getAll(): List<Wish>
}