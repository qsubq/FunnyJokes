package com.github.qsubq.funnyjockes

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.qsubq.funnyjockes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animationDrawable: AnimationDrawable =
            (binding.mainLayout.background as AnimationDrawable).apply {
                setEnterFadeDuration(2500)
                setExitFadeDuration(5000)
                start()
            }
    }
}