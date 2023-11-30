package com.example.mytest.aeon.di

import com.example.mytest.aeon.utils.APP_KEY
import com.example.mytest.aeon.utils.V_KEY
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("app-key", APP_KEY)
            .addQueryParameter("v", V_KEY)
            .build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)    }
}