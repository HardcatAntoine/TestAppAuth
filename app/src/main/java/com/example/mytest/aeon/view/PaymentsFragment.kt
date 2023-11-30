package com.example.mytest.aeon.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mytest.aeon.R
import com.example.mytest.aeon.databinding.FragmentPaymentsBinding
import com.example.mytest.aeon.viewmodel.LoginViewModel

class PaymentsFragment : Fragment() {
    lateinit var binding: FragmentPaymentsBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentsBinding.inflate(layoutInflater)
        return binding.root
    }
}