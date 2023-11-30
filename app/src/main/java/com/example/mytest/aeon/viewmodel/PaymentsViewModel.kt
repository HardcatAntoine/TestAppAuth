package com.example.mytest.aeon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytest.aeon.data.model.Payments
import com.example.mytest.aeon.data.repo.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PaymentsViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    private val _paymentsList = MutableLiveData<List<Payments>>()
    val paymentsList: LiveData<List<Payments>>
        get() = _paymentsList

    suspend fun getPaymentsList() {
        val token = repository.getSavedToken()
        if (!token.isNullOrEmpty()) {
            val response = repository.getPaymentsList(token)
            _paymentsList.value = response.response
        }
    }
    fun removeToken(){
        repository.removeToken()
    }
}