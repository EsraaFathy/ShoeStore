package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var _mainActivityMainBinding : ActivityMainBinding?= null
    private val mainActivityMainBinding get() = _mainActivityMainBinding!!

    private var _navController: NavController? = null
    private val navController: NavController get() = _navController!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       _mainActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainActivityMainBinding.root)

        _navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)
        mainActivityMainBinding.toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->


            when (destination.id ) {
                R.id.on_boarding_nav_fragment-> {
                    mainActivityMainBinding.toolbar.visibility = View.VISIBLE
                    mainActivityMainBinding.toolbar.navigationIcon = null

                } R.id.instruction_nav_fragment-> {
                mainActivityMainBinding.toolbar.navigationIcon = null

                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _mainActivityMainBinding = null
        _navController = null
    }
}
