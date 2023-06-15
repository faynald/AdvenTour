package com.c23pr591.adventour.ui.auth.signup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.c23pr591.adventour.R
import com.c23pr591.adventour.core.data.network.request.SignupRequest
import com.c23pr591.adventour.databinding.FragmentSignUpBinding
import com.c23pr591.adventour.ui.auth.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val binding: FragmentSignUpBinding by viewBinding()
    private val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupOnClick()
        setupDropDown()
    }

    private fun setupOnClick() {
        binding.tvLogin.setOnClickListener {
            val fragment = LoginFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit()
        }
        binding.buttonSignup.setOnClickListener {
            val nama = binding.etUserName.text.toString()
            val jenisKelamin = binding.acJenisKelamin.text.toString()
            val umur = binding.etUmur.text.toString().toInt()
            val domisili = binding.etDomisili.text.toString()
            val pengalaman = binding.etPengalaman.text.toString().toInt()
            val email = binding.etEmailAddress.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()
            val user = SignupRequest(
                name = nama,
                gender = jenisKelamin,
                age = umur,
                domicile = domisili,
                experience = pengalaman,
                email = email,
                password = password,
                confirmPassword = confirmPassword
            )
            viewModel.signUp(user) {
                if (it?.message == "Success SignUp") {
                    val fragment = LoginFragment()
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment)
                        .commit()
                    Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Terjadi kesalahan, harap periksa data anda", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupDropDown() {
        val items = listOf("Laki-Laki", "Perempuan")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.acJenisKelamin.setAdapter(adapter)
    }
}