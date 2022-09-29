package com.gnosis.bucketlistgroup.data.api

import com.gnosis.bucketlistgroup.data.db.Wish
import retrofit2.Response
import retrofit2.http.GET

interface WishesApi {
    @GET("wishes")
    suspend fun getAll(): Response<List<Wish>>
}