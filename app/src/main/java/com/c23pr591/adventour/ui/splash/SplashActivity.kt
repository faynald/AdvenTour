package com.c23pr591.adventour.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import com.c23pr591.adventour.R
import com.c23pr591.adventour.databinding.ActivitySplashBinding
import com.c23pr591.adventour.ui.auth.AuthActivity
import com.c23pr591.adventour.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_logo_animation)
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_text_fade_in)
        logoAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
        binding.linear.startAnimation(textAnimation)

        textAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.linearText.visibility = View.VISIBLE
                viewModel.getToken().observe(this@SplashActivity) { userLogin ->
                    if (userLogin.isNotEmpty()) {
                        Log.e("userLogin.isNotEmpty", userLogin.toString())
                        val intent = Intent(this@SplashActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Log.e("userLogin.isEmpty", userLogin.toString())
                        val intent = Intent(this@SplashActivity, AuthActivity::class.java)
                        startActivity(intent)
                        finish()
//                        viewModel.insertNullToken()
                    }
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

    }
}