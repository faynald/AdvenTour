package com.c23pr591.adventour.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.c23pr591.adventour.R
import com.c23pr591.adventour.databinding.ActivityMainBinding
import com.c23pr591.adventour.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.bottomNavView
        val navController = findNavController(R.id.nav_host_fragment_activity_home)

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_explore, R.id.navigation_whistlist, R.id.navigation_setting
//            )
//        )
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }
}