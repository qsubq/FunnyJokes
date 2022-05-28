package com.github.qsubq.funnyjockes.screen.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.qsubq.funnyjockes.R
import com.github.qsubq.funnyjockes.data.model.JokeModel
import com.github.qsubq.funnyjockes.databinding.FragmentJokeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JokeFragment : Fragment() {
    private lateinit var binding: FragmentJokeBinding
    private val viewModel: JokeViewModel by viewModels()

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
            if (binding.tvJoke.text.isNotEmpty()) {
                binding.tvJoke.text = ""
            }

            binding.btnJoke.isEnabled = false
            binding.progressBar.visibility = View.VISIBLE

            if (viewModel.isOnline()) {
                viewModel.getJoke()
            } else {
                binding.progressBar.visibility = View.GONE
                binding.tvJoke.text = getString(R.string.connection_error)
            }
            binding.btnJoke.isEnabled = true
        }

        binding.btnFavourite.setOnClickListener {
            if (binding.tvJoke.text != ""
                && binding.tvJoke.text != " "
                && binding.tvJoke.text != getString(R.string.connection_error)
            ) {
                viewModel.insertJoke(JokeModel(0, binding.tvJoke.text.toString()))
            }
        }
    }

}