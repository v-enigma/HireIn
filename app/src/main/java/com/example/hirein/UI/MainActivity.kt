package com.example.hirein.UI

import android.os.Bundle
import android.view.Menu
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.hirein.R
import com.example.hirein.data.UserIdViewModel
import com.example.hirein.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
     lateinit var binding : ActivityMainBinding
     private lateinit var userIdViewModel :UserIdViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        var userId = 1L
        super.onCreate(savedInstanceState)
        userIdViewModel = ViewModelProvider(this).get(UserIdViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        userIdViewModel.setUserId(userId)
        println("Setup  userId")
        val navHost = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        setBottomNavigationWithHideBehaviour(navHost)
        val bundle = Bundle()
        bundle.putLong("userId", userId)
        navHost.navController.setGraph(R.navigation.mobile_navigation, bundle)
        setupActionBar(binding.topAppBar)


    }


//    override fun onNavigateUp(): Boolean {
//        val navController = Navigation.findNavController(this,R.id.my_nav_host_fragment)
//        return navController.navigateUp()
//
//    }

    private fun setUpBottomNavMenu(navController: NavController){
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)

    }

    override fun onResume() {
        super.onResume()

        println("Main Activity on focus")
    }
    private fun setBottomNavigationWithHideBehaviour(navHost: NavHostFragment){
        //val navHost = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment ?: return
        setUpBottomNavMenu(navHost.navController)
        navHost.navController.addOnDestinationChangedListener{ _, destination, _ ->
            //println("Inside the listiner")
            when(destination.id){
                R.id.homeFragment ,R.id.connectionsFragment, R.id.newPostFragment, R.id.userDashboardFragment-> binding.bottomNavView.visibility = View.VISIBLE
                else -> binding.bottomNavView.visibility = View.GONE
            }
        }

    }
    fun setupActionBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
        setOf(R.id.homeFragment,R.id.connectionsFragment, R.id.newPostFragment,R.id.userDashboardFragment))
        //NavigationUI.setupActionBarWithNavController(this, navController)
        binding.topAppBar.setupWithNavController(navController, appBarConfiguration)

    }
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        println("I am inside Activity menu")
//        menuInflater.inflate(R.menu.tool_bar_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//    private fun setUpButton(navHost: NavHostFragment){
//        val navController = navHost.findNavController()
//        NavigationUI.setupActionBarWithNavController(this, navController)
//
//    }

}