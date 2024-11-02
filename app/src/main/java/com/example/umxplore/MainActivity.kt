package com.example.umxplore

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.umxplore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Handle navigation based on login status
        val showAkunTerdaftar = intent.getBooleanExtra("show_akun_terdaftar", false)
        val userId = intent.getIntExtra("user_id", 0)

        if (showAkunTerdaftar && userId != 0) {
            // Navigate to AkunTerdaftar with user data
            val bundle = Bundle().apply {
                putInt("user_id", userId)
            }
            navController.navigate(R.id.navigation_akun_terdaftar, bundle)
        }

        // Setup navigation
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard,
                R.id.navigation_faq, R.id.navigation_akun,
                R.id.navigation_akun_terdaftar
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Custom navigation listener
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_akun -> {
                    if (userId != 0) {
                        navController.navigate(R.id.navigation_akun_terdaftar)
                    } else {
                        navController.navigate(R.id.navigation_akun)
                    }
                    true
                }
                else -> {
                    navController.navigate(item.itemId)
                    true
                }
            }
        }

        supportActionBar?.hide()
    }
}