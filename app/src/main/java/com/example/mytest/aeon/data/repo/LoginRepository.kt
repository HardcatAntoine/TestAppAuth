package com.example.mytest.aeon.data.repo

import com.example.mytest.aeon.data.local.Preferences
import com.example.mytest.aeon.data.model.PaymentsResponse
import com.example.mytest.aeon.data.model.TokenResponse
import com.example.mytest.aeon.data.remote.ApiService
import com.example.mytest.aeon.utils.APP_KEY
import com.example.mytest.aeon.utils.V_KEY
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    private val preferences: Preferences
) {
    suspend fun getToken(
        loginPassword: HashMap<String, String>
    ): TokenResponse {
        return apiService.getToken(
            apiKey = APP_KEY,
            v = V_KEY,
            loginPassword
        )
    }

    suspend fun getPaymentsList(token: String): PaymentsResponse {
        return apiService.getPaymentsList(
            apiKey = APP_KEY,
            v = V_KEY,
            token
        )
    }

    fun saveToken(token: String?) {
        preferences.saveToken(token)
    }

    fun getSavedToken(): String? {
        return preferences.getSavedToken()
    }
    fun removeToken(){
        preferences.clearPreferences()
    }
}