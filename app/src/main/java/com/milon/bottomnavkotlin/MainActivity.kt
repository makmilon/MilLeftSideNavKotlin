package com.milon.bottomnavkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.milon.bottomnavkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController:NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);


        navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.navController

        appBarConfiguration= AppBarConfiguration(navController.graph,binding.drawerLayout)
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)
        binding.navView.setupWithNavController(navController)


        binding.fab.setOnClickListener {
                 startActivity(Intent(this,FabActivity::class.java))
        }

        NavigationUI.setupWithNavController(binding.bottomNavigationView,navController)

    }


}