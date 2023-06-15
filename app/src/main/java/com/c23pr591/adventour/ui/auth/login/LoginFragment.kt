package com.c23pr591.adventour.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.c23pr591.adventour.R
import com.c23pr591.adventour.core.data.network.request.SigninRequest
import com.c23pr591.adventour.databinding.FragmentLoginBinding
import com.c23pr591.adventour.ui.auth.signup.SignUpFragment
import com.c23pr591.adventour.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding()
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            setupOnClick()
        }

    }

    private fun setupOnClick() {
        binding.tvSignUp.setOnClickListener {
            val fragment = SignUpFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.buttonLogin.setOnClickListener{
            val email = binding.etEmailAddress.text.toString()
            val password = binding.etPassword.text.toString()
            val user = SigninRequest(
                email,
                password
            )
            viewModel.signIn(user) {
                if (it?.data != null) {
                    Log.e("response.data", "is not null")
                    Log.e("response.data", it.data!!)
                    val intent = Intent(activity, MainActivity::class.java)
                    activity?.startActivity(intent)
                } else {
                    Log.e("SignIn Fail", it?.message.toString())
                    Toast.makeText(requireContext(), "Check Email and Password then try again", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}