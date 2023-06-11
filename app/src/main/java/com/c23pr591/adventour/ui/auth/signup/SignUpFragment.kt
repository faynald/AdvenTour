package com.c23pr591.adventour.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.c23pr591.adventour.R
import com.c23pr591.adventour.databinding.FragmentSignUpBinding
import com.c23pr591.adventour.ui.auth.login.LoginFragment

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val binding: FragmentSignUpBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupOnClick()
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
    }
}