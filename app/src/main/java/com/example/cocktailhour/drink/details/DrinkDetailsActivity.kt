package com.example.cocktailhour.drink.details

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.viewpager2.widget.ViewPager2
import com.example.cocktailhour.DrinkViewModel
import com.example.cocktailhour.IngredientViewModel
import com.example.cocktailhour.R
import com.example.cocktailhour.database.*
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext

class DrinkDetailsActivity : AppCompatActivity() {
    private var  drink: Drink? = null
    private var  ingredient: Ingredient? = null
    private lateinit var ingredientViewModel: IngredientViewModel

    private lateinit var nameTextView: TextView
    private lateinit var tagsTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var alcoholicTextView: TextView
    private lateinit var glassTextView: TextView
    private lateinit var instructionsTextView: TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_details)

        drink = intent.getParcelableExtra<Drink>("drink")
        ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)
        drink?.id?.let { ingredientViewModel.getIngredientById(it) }

        //ingredient = ingredientViewModel.ingredient




        val viewPager2 = findViewById<ViewPager2>(R.id.pager2_container)

        val fragmentList = arrayListOf(
            DetailsFragment.newInstance(),
            IngredientFragment.newInstance(),
            GalleryFragment.newInstance()
        )
        viewPager2.adapter = ViewPagerAdapter(this, fragmentList)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = getTabText(position)
        }.attach()

        val toast = Toast.makeText(applicationContext, ingredient.toString(), Toast.LENGTH_LONG)
        toast.show()
    }

    fun getTabText(position: Int): String {
        var tabText: String = "Details"

        when (position) {
            1 -> tabText = "Ingredients"
            2 -> tabText = "Gallery"
        }

        return tabText
    }

    fun getMyDrink(): Drink? {
        return drink
    }

    fun getMyIngredient(): Ingredient? {
        return ingredient
    }
}