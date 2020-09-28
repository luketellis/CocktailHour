package com.example.cocktailhour

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    private val newDrinkActivityRequestCode = 1
    private lateinit var drinkViewModel: DrinkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_recipes, R.id.navigation_timer))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }



/*    private fun initData(): List<Drink> {
        val data = mutableListOf<Drink>()
        data.add(Drink(1, "Margharitta", "Alochol",
            "large", "instuctions", "www.google.com",
            mutableListOf(), mutableListOf()))

        data.add(Drink(2, "Volcano", "Alochol",
            "large", "instuctions2", "www.yahoo.com",
            mutableListOf(), mutableListOf()))

        return data
    }*/
}