package com.example.motion

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.example.motion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var toRightAnimation = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMotion()
    }

    private fun initMotion() {
        val displayWidth = Resources.getSystem().displayMetrics.widthPixels
        val displayHeight = Resources.getSystem().displayMetrics.heightPixels
        binding.button.setOnClickListener {
            val path = listOf<ObjectAnimator>(
                ObjectAnimator.ofFloat(binding.button, "translationX", displayWidth - 200f),
                ObjectAnimator.ofFloat(binding.button, "translationY", 300f),
                ObjectAnimator.ofFloat(binding.button, "translationX", 12f),
                ObjectAnimator.ofFloat(binding.button, "translationY", 600f),
                ObjectAnimator.ofFloat(binding.button, "translationX", displayWidth - 200f),
                ObjectAnimator.ofFloat(binding.button, "translationY", displayHeight - 250f)
            )

            AnimatorSet().apply {
                playSequentially(path)
                duration = 1000
                start()
            }
        }
    }
}

