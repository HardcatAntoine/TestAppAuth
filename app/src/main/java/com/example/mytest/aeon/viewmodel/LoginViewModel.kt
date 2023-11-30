package com.example.mytest.aeon.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mytest.aeon.data.repo.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    suspend fun getToken(login: String, password: String) {
        val mapForToken = hashMapOf<String, String>()
        mapForToken["login"] = login
        mapForToken["password"] = password
        val token = repository.getToken(mapForToken)
        repository.saveToken(token)
    }
}