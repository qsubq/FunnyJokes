package com.github.qsubq.funnyjockes

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.qsubq.funnyjockes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

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

        binding.progressBar.visibility = View.GONE

        viewModel.jokeLiveData.observe(this) { response ->
            binding.progressBar.visibility = View.GONE
            binding.tvJoke.text = response.body()?.joke
            binding.btnJoke.isEnabled = true
        }

        binding.btnJoke.setOnClickListener {
            binding.tvJoke.text = ""
            binding.btnJoke.isEnabled = false
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getJoke()


        }
    }
}