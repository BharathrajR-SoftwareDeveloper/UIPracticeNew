package com.example.uipractice.Pagination.api

import com.example.uipractice.Pagination.api.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("products")
    suspend fun getProduct(
        @Query("limit") limit:Int,
        @Query("skip") skip:Int
    ): ProductResponse

}