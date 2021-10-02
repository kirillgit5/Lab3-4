package com.example.lab3_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lab3_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setupBottomNavigationBar()
        setContentView(binding.root)
    }

    private fun setupBottomNavigationBar() {
        binding.botNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_events -> {openFragment(EventsFragment())
                    true}
                R.id.navigation_holidays -> {openFragment(HolidaysFragment())
                    true}
                R.id.navigation_profile -> {openFragment(HomeFragment())
                    true}
                else -> true
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_home, fragment)
            .addToBackStack(null)
            .commit()
    }
}