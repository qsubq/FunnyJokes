package com.github.qsubq.funnyjockes.screen.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.qsubq.funnyjockes.databinding.FragmentFavouriteBinding
import com.github.qsubq.funnyjockes.domain.adapter.FavouriteAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteBinding
    private val adapter by lazy {
        FavouriteAdapter()
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[FavouriteViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.rcView.adapter = adapter

        viewModel.getFavouriteJokes().observe(viewLifecycleOwner) { listJokes ->
            adapter.setList(listJokes)
        }

        viewModel.getFavouriteJokes()
    }
}