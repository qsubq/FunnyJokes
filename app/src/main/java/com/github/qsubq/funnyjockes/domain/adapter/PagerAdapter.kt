package com.github.qsubq.funnyjockes.domain.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.qsubq.funnyjockes.screen.favourite.FavouriteFragment
import com.github.qsubq.funnyjockes.screen.joke.JokeFragment

class PagerAdapter(fragment : FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) JokeFragment()
        else {FavouriteFragment()}
    }
}