package com.github.qsubq.funnyjockes.screen.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.qsubq.funnyjockes.data.model.JokeModel
import com.github.qsubq.funnyjockes.databinding.FragmentJokeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JokeFragment : Fragment() {

    companion object {
        const val IDM_OPEN = 101
        const val IDM_SAVE = 102
    }

    private lateinit var binding: FragmentJokeBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[JokeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJokeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

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

        binding.btnFavourite.setOnClickListener {
            if (binding.tvJoke.text != "" && binding.tvJoke.text != " ") {
                viewModel.insertJoke(JokeModel(0, binding.tvJoke.text.toString()))
            }
        }
    }
}