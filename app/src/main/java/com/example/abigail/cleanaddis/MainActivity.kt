package com.example.abigail.cleanaddis

import android.os.AsyncTask
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.abigail.cleanaddis.controller.news.NewsFragment

import com.example.abigail.cleanaddis.utility.replaceFragmenty



import com.example.abigail.cleanaddis.connectDatabase.news.NewsDatabase
import com.example.abigail.cleanaddis.data.news.NewsDAO

import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var newsDatabase:  NewsDatabase
    private  lateinit var  newsDAO: NewsDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar?)

        AsyncTask.execute {
            newsDatabase= NewsDatabase.getDatabase(this)
            newsDAO =newsDatabase.newsDao()
        }
       /* The above async and this should be added to the fragment not here cause its alot
       and also the UI elemenets are accessed in the fragments not here
       this is just to show the way how betsegaw did
       addButton.setOnClickListener {

            val news=readFields() our method where we wrote the code that reads the data from the UI
            AsyncTask.execute{
                saveNews(news) This method is written below
            }
        }*/
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar as Toolbar?, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }
   /* private fun saveNews(news:News){
        newsDAO.insertNews(news)
    }*/
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {


                replaceFragmenty(
                    NewsFragment(),
                    true,
                   R.id.linearlayout_fragment_area
                )
                setTitle("News")


            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
