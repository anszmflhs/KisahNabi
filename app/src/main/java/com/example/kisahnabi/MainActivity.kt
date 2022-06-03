package com.example.kisahnabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kisahnabi.adapter.TabAdapter
import com.example.kisahnabi.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = TabAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout,binding.viewPager) {tab, position ->
            when (position) {
                0 -> {
                    tab.text = "25 Nabi"
                }
                1 -> {
                    tab.text = "Rasul"
                }
            }
        }.attach()
    }
}