package com.example.mytest.aeon.data.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/login")
    suspend fun auth(@Body body: HashMap<String, String>): String?

    @GET("/payments")
    suspend fun getPaymentsList(
        @Query("token") token: String
    ): List<String>
}