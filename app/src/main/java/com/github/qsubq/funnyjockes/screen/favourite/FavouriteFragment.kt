package com.github.qsubq.funnyjockes.screen.favourite

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.qsubq.funnyjockes.R
import com.github.qsubq.funnyjockes.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {

    private lateinit var binding : FragmentFavouriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val animationDrawable: AnimationDrawable =
            (binding.favouriteLayout.background as AnimationDrawable).apply {
                setEnterFadeDuration(2500)
                setExitFadeDuration(5000)
                start()
            }
    }
}