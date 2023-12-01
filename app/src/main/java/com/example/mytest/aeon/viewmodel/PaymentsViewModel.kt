package com.example.mytest.aeon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytest.aeon.data.model.Payment
import com.example.mytest.aeon.data.repo.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentsViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    private val _paymentList = MutableLiveData<List<Payment>>()
    val paymentList: LiveData<List<Payment>>
        get() = _paymentList

    fun getPaymentsList() {
        val token = repository.getSavedToken()
        if (!token.isNullOrEmpty()) {
            viewModelScope.launch {
                val response = repository.getPaymentsList(token)
                _paymentList.value = response.payment
            }
        }
    }

    fun getSavedToken(): String? {
        return repository.getSavedToken()
    }

    fun removeToken() {
        repository.removeToken()
    }
}