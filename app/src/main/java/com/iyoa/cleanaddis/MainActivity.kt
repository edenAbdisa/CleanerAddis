package com.iyoa.cleanaddis

import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.iyoa.cleanaddis.controller.news.ArticleFragment

import com.iyoa.cleanaddis.utility.replaceFragmenty



//import com.example.abigail.cleanaddis.connectDatabase.news.ArticleDatabase

import com.google.android.material.navigation.NavigationView
import com.iyoa.cleanaddis.controller.posting.PostFragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //private lateinit var newsDatabase:  ArticleDatabase
    //private  lateinit var  newsDAO: NewsDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar )

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar , R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupSideNavigationMenu(navController)
        setupActionBar(navController)
    }


    private fun setupSideNavigationMenu(navController: NavController) {
        nav_view?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val navigated = NavigationUI.onNavDestinationSelected(item!!, navController)
        return navigated || super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    @RequiresApi(28)
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val navigated = NavigationUI.onNavDestinationSelected(item!!, navController)
        return navigated || super.onOptionsItemSelected(item)
    }


}
