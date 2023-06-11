package com.c23pr591.adventour.ui.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.c23pr591.adventour.R
import com.c23pr591.adventour.databinding.FragmentLoginBinding
import com.c23pr591.adventour.ui.auth.signup.SignUpFragment
import com.c23pr591.adventour.ui.main.MainActivity

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding()

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
            val intent = Intent(activity, MainActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}