package com.example.mytest.aeon.data.model

data class PaymentsResponse(
    val response: List<Payment>,
    val success: String
)