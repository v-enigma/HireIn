package com.example.hirein.UI

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.hirein.R
import com.example.hirein.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
     lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val navHost = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment ?: return
        setUpBottomNavMenu(navHost.navController)
        navHost.navController.addOnDestinationChangedListener{ _, destination, _ ->
            println("Inside the listiner")
            when(destination.id){
               R.id.homeFragment -> binding.bottomNavView.visibility = View.VISIBLE
                else -> binding.bottomNavView.visibility = View.GONE
            }
        }
    }



    private fun setUpBottomNavMenu(navController: NavController){
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        println("Main Activity on focus")
    }

}