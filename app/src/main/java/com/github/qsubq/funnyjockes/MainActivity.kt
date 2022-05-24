package com.github.qsubq.funnyjockes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.qsubq.funnyjockes.databinding.ActivityMainBinding
import com.github.qsubq.funnyjockes.domain.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initial()
    }

    private fun initial() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.tabIconTint = null

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.setIcon(R.drawable.ic_baseline_speaker_notes_24)
                    tab.icon?.setTint(getColor(R.color.red_500))
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_baseline_favorite_24)
                    tab.icon?.setTint(getColor(R.color.red_500))
                    tab.icon?.alpha = 70
                }
            }

        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })


    }
}