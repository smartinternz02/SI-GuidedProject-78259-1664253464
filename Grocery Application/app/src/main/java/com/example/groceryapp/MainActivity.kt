package com.example.groceryapp
import android.graphics.fonts.Font
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
    }
}