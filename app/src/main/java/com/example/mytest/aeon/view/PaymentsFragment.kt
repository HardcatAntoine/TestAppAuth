package com.example.mytest.aeon.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytest.aeon.R
import com.example.mytest.aeon.databinding.FragmentPaymentsBinding
import com.example.mytest.aeon.viewmodel.LoginViewModel
import com.example.mytest.aeon.viewmodel.PaymentsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentsFragment : Fragment() {
    lateinit var binding: FragmentPaymentsBinding
    private val viewModel: PaymentsViewModel by viewModels()
    private val adapter = PaymentsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.paymentsList.observe(viewLifecycleOwner) { list ->
            adapter.setList(list)
        }
        binding.btnLogOut.setOnClickListener {
            findNavController().navigateUp()
            viewModel.removeToken()
        }

    }

    private fun initAdapter() {
        binding.rvPayments.adapter = adapter
        binding.rvPayments.layoutManager = LinearLayoutManager(requireContext())
    }
}