package com.example.cocktailhour.drink.edit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.example.cocktailhour.R
import com.example.cocktailhour.database.CocktailHourRoomDatabase
import com.example.cocktailhour.drink.DrinkViewModel
import com.example.cocktailhour.drink.add.AddDrinkActivity
import com.example.cocktailhour.drink.IngredientViewModel
import com.example.cocktailhour.drink.details.ViewPagerAdapter
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.Ingredient
import com.example.cocktailhour.entitiy.IngredientDTO
import com.example.cocktailhour.entitiy.IngredientMeasure
import com.example.cocktailhour.misc.Validations
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class EditDrinkActivity : AppCompatActivity() {
    private lateinit var drinkViewModel: DrinkViewModel
    private lateinit var ingredientViewModel: IngredientViewModel
    private val ingredientMeasureList = ArrayList<IngredientMeasure>()


    private var potentialIngredient : IngredientDTO = IngredientDTO()
    private var drink: Drink? = null
    var ingredient: Ingredient? = null


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity_drink_tabs)

        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)
        ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)

        drink = intent.getParcelableExtra<Drink>("drink")

/*        GlobalScope.launch {
            ingredient = ingredientViewModel.getIngredientById(drink.id)
        }*/


        var db= Room.databaseBuilder(applicationContext,CocktailHourRoomDatabase::class.java,"Cocktails").build()

        val thread = Thread {
            //drink?.id?.let { ingredientViewModel.getIngredientById(it) }
            var ingredient : Ingredient = db.ingredientDao().getIngredientById(drink?.id)
            setIngredientPlz(ingredient)
         }

        thread.start()

        val viewPager2 = findViewById<ViewPager2>(R.id.pager2_container)

        val fragmentList = arrayListOf(
            EditDrinkDetailsFragment.newInstance(),
            EditIngredientFragment.newInstance()
        )
        viewPager2.adapter = ViewPagerAdapter(this, fragmentList)


        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = getTabText(position)
        }.attach()

    }

    private fun setIngredientPlz(retrievedIngredient: Ingredient) {
        ingredient = retrievedIngredient
    }

    private fun displayShortToastValidation(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun updateIngredientInActivity(updatedIngredient: IngredientDTO) {
        potentialIngredient = updatedIngredient
    }

    fun updateDrinkAndReturnToMainMenu(name: String, category: String, tags: String, instructions: String, alcoholic: String, glass: String) {

        if (!Validations.isPotentialIngredientValid(potentialIngredient)) {

            displayShortToastValidation("Drinks need at least two ingredients and measures")
            return
        }

        if (!Validations.isOptionalIngredientMeasureComplete(potentialIngredient)) {

            displayShortToastValidation("Please check that for every Ingredient row you have specified an ingredient and measure")
            return
        }

        var drink : Drink = Drink(null, name, null, tags, category, alcoholic, glass, instructions, null, null, java.util.Calendar.getInstance().toString(), 0)
        drinkViewModel.insert(drink!!)

        val intent = Intent(this, AddDrinkActivity::class.java).apply {
            putExtra("newDrink", drink)
            setResult(RESULT_OK, this)
        }

        super.onBackPressed()
    }

    fun getMyDrink(): Drink? {
        return drink
    }

    fun getMyIngredient(): Ingredient? {
        return ingredient
    }

    private fun getTabText(position: Int): String {
        var tabText: String = "Details"

        when (position) {
            1 -> tabText = "Ingredients"
        }

        return tabText
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.drinklistsql.REPLY"
    }

}