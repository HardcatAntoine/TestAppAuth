package com.example.mytest.aeon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mytest.aeon.R
import com.example.mytest.aeon.databinding.FragmentLoginBinding
import com.example.mytest.aeon.viewmodel.LoginViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSignIn.setOnClickListener {
            val login = binding.login.text.toString()
            val password = binding.password.text.toString()
            if (login.isNullOrEmpty() || password.isNullOrEmpty()) {
                showAlertDialog()
            } else {
                lifecycleScope.launch {
                    val token = viewModel.getToken(login, password)
                    if (token.toString().isNullOrEmpty()) {
                        showAlertDialog()
                    } else {
                        findNavController().navigate(R.id.action_loginFragment_to_paymentsFragment)
                    }
                }
            }
        }
    }

    private fun showAlertDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Error")
            .setMessage("Invalid login or password")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }
}