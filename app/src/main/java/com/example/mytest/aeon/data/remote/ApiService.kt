package com.example.mytest.aeon.data.remote

import com.example.mytest.aeon.data.model.PaymentsResponse
import com.example.mytest.aeon.data.model.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun getToken(
        @Header("app-key") apiKey: String,
        @Header("v") v: String,
        @Body body: HashMap<String, String>
    ): TokenResponse

    @GET("/payments")
    suspend fun getPaymentsList(
        @Header("app-key") apiKey: String,
        @Header("v") v: String,
        @Header("token") token: String
    ): PaymentsResponse
}