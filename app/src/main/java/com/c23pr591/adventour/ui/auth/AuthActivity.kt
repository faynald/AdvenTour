package com.c23pr591.adventour.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c23pr591.adventour.R
import com.c23pr591.adventour.databinding.ActivityAuthBinding
import com.c23pr591.adventour.ui.auth.login.LoginFragment

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, LoginFragment())
                .commit()
        }

    }
}