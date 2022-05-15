package com.github.qsubq.funnyjockes.screen.joke

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.github.qsubq.funnyjockes.MainViewModel
import com.github.qsubq.funnyjockes.R
import com.github.qsubq.funnyjockes.databinding.FragmentJokeBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class JokeFragment : Fragment() {

    private lateinit var binding : FragmentJokeBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[JokeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJokeBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val animationDrawable: AnimationDrawable =
            (binding.jokeLayout.background as AnimationDrawable).apply {
                setEnterFadeDuration(2500)
                setExitFadeDuration(5000)
                start()
            }

        binding.progressBar.visibility = View.GONE

        viewModel.jokeLiveData.observe(viewLifecycleOwner) { response ->
            binding.progressBar.visibility = View.GONE
            binding.tvJoke.text = response.body()?.joke
            binding.btnJoke.isEnabled = true
        }

        binding.btnJoke.setOnClickListener {
            binding.btnJoke.isEnabled = false
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getJoke()
        }
    }

}