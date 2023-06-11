package com.c23pr591.adventour.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.c23pr591.adventour.R
import com.c23pr591.adventour.databinding.ActivitySplashBinding
import com.c23pr591.adventour.ui.auth.AuthActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_logo_animation)
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_text_fade_in)
        binding.logo.startAnimation(logoAnimation)
        logoAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.linearText.startAnimation(textAnimation)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })

        textAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                val intent = Intent(this@SplashActivity, AuthActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

    }
}