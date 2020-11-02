package com.example.cocktailhour.drink.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.example.cocktailhour.R
import com.example.cocktailhour.database.*
import com.example.cocktailhour.drink.IngredientViewModel
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.Ingredient
import com.example.cocktailhour.entitiy.IngredientMeasure
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DrinkDetailsActivity : AppCompatActivity() {
    private var  drink: Drink? = null
    private lateinit var ingredientViewModel: IngredientViewModel
    private val ingredientMeasureList = ArrayList<IngredientMeasure>()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_details_tabs)

        drink = intent.getParcelableExtra<Drink>("drink")
        ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)


        var db= Room.databaseBuilder(applicationContext,CocktailHourRoomDatabase::class.java,"Cocktails").build()

        val thread = Thread {
            //drink?.id?.let { ingredientViewModel.getIngredientById(it) }
            var ingredient : Ingredient = db.ingredientDao().getIngredientById(drink?.id)

            if (ingredient != null) {
                if (ingredient.ingredient1 != null)
                    ingredientMeasureList.add(IngredientMeasure(ingredient.ingredient1,
                        ingredient.measure1))

                if (ingredient.ingredient2 != null)
                    ingredientMeasureList.add(IngredientMeasure(ingredient.ingredient2,
                        ingredient.measure2))

                if (ingredient.ingredient3 != null)
                    ingredientMeasureList.add(IngredientMeasure(ingredient.ingredient3!!,
                        ingredient.measure3!!))

                if (ingredient.ingredient4 != null)
                    ingredientMeasureList.add(IngredientMeasure(ingredient.ingredient4!!,
                        ingredient.measure4!!))

                if (ingredient.ingredient5 != null)
                    ingredientMeasureList.add(IngredientMeasure(ingredient.ingredient5!!,
                        ingredient.measure5!!))

                if (ingredient.ingredient6 != null)
                    ingredientMeasureList.add(IngredientMeasure(ingredient.ingredient6!!,
                        ingredient.measure6!!))

                if (ingredient.ingredient7 != null)
                    ingredientMeasureList.add(IngredientMeasure(ingredient.ingredient7!!,
                        ingredient.measure7!!))
            }
        }

        thread.start()


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

    }

    private fun getTabText(position: Int): String {
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

    fun getMyIngredients(): ArrayList<IngredientMeasure> {
        return ingredientMeasureList
    }
}