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
import com.example.mytest.aeon.viewmodel.PaymentsViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
        viewModel.getPaymentsList()
        viewModel.paymentList.observe(viewLifecycleOwner) { list ->
            adapter.setList(list)
        }
        binding.btnLogOut.setOnClickListener {
            showAlertDialog()
        }

    }

    private fun initAdapter() {
        binding.rvPayments.adapter = adapter
        binding.rvPayments.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun showAlertDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Log out")
            .setMessage("Are you sure?")
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }
            .setPositiveButton("Yes") { dialog, _ ->
                viewModel.removeToken()
                findNavController().navigate(R.id.action_paymentsFragment_to_loginFragment)
            }
            .show()
    }
}