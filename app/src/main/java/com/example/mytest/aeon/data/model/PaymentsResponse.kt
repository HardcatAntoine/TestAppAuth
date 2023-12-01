package com.example.mytest.aeon.data.model

data class PaymentsResponse(
    val payment: List<Payment>,
    val success: String
)