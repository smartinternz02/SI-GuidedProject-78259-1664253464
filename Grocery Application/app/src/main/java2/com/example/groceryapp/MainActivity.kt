package com.example.groceryapp
<<<<<<< HEAD
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import com.example.groceryapp.R
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.navigation.NavController
class MainActivity : AppCompatActivity() {
    private var mAppBarConfiguration: AppBarConfiguration? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration =Builder(
            R.id.nav_home,
            R.id.nav_category,
            R.id.nav_profile,
            R.id.nav_offers,
            R.id.nav_new_products,
            R.id.nav_my_orders,
            R.id.nav_my_carts
        )
            .setOpenableLayout(drawer)
            .build()
        val navController = findNavController(this, R.id.nav_host_fragment_content_main)
        setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
        setupWithNavController(navigationView, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(this, R.id.nav_host_fragment_content_main)
        return (navigateUp(navController, mAppBarConfiguration!!)
                || super.onSupportNavigateUp())
=======

import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth
import android.os.Bundle
import com.example.groceryapp.R
import android.content.Intent
import android.view.View
import com.example.groceryapp.MainActivity
import android.widget.Toast
import com.example.groceryapp.LoginActivity
import com.example.groceryapp.RegistrationActivity

class MainActivity : AppCompatActivity() {
    var progressBar: ProgressBar? = null
    var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        progressBar = findViewById(R.id.progressbar)
        if (auth!!.currentUser != null) {
            startActivity(Intent(this@MainActivity, MainActivity::class.java))
            Toast.makeText(this, "please wait you are already logged in", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun login(view: View?) {
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
    }

    fun registration(view: View?) {
        startActivity(Intent(this@MainActivity, RegistrationActivity::class.java))
>>>>>>> 3e30cfd (Final Commit)
    }
}