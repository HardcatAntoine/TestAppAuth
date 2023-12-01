package com.example.mytest.aeon.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mytest.aeon.data.repo.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.ResponseBody
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    suspend fun getToken(login: String, password: String): String? {
        val mapForToken = hashMapOf<String, String>()
        mapForToken["login"] = login
        mapForToken["password"] = password
        val response = repository.getToken(mapForToken)
        val token = response.response.token
        repository.saveToken(token)
        Log.d("INPUT TOKEN", token)
        Log.d("SAVE TOKEN Login VM", repository.getSavedToken().toString())
        return token
    }

    fun getSavedToken(): String? {
        return repository.getSavedToken()
    }
}
