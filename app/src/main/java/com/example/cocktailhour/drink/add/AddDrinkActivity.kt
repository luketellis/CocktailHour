package com.example.cocktailhour.drink.add

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.example.cocktailhour.R
import com.example.cocktailhour.database.CocktailHourRoomDatabase
import com.example.cocktailhour.drink.DrinkViewModel
import com.example.cocktailhour.drink.details.*
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.IngredientMeasure
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.time.LocalDateTime

class AddDrinkActivity: AppCompatActivity() {
    private val ingredientMeasureList = ArrayList<IngredientMeasure>()

    private lateinit var drinkViewModel: DrinkViewModel
    private lateinit var ingredientViewModel: IngredientViewModel

    private lateinit var nameEditText: EditText
    private lateinit var tagsEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var alcoholicEditText: EditText
    private lateinit var glassEditText: EditText
    private lateinit var instructionsEditText: EditText

        private lateinit var editDrinkView: EditText

        public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.add_activity_drink_tabs)

            ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)
            drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)

            var db= Room.databaseBuilder(applicationContext, CocktailHourRoomDatabase::class.java,"Cocktails").build()



            val viewPager2 = findViewById<ViewPager2>(R.id.pager2_container)

            val fragmentList = arrayListOf(
                AddDrinkDetailsFragment.newInstance(),
                AddIngredientFragment.newInstance()
            )
            viewPager2.adapter = ViewPagerAdapter(this, fragmentList)

            val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = getTabText(position)
            }.attach()

/*            val button = findViewById<Button>(R.id.button_save)
            button.setOnClickListener {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(editDrinkView.text)) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val drink = Drink(null, editDrinkView.text.toString(), "German Name", "Tags","category",
                        "Alcoholic","Mug", "instructions", "German Instructions","thumbnail", "12/05/1991", 0)

                    replyIntent.putExtra(EXTRA_REPLY, drink)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                finish()
            }*/
        }

    fun displayToastValidation(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun addDrink(name: String, category: String, tags: String, instructions: String, alcoholic: String, glass: String) {

        var drink : Drink = Drink(null, name, null, tags, category, alcoholic, glass, instructions, null, null, java.util.Calendar.getInstance().toString(), 0)

        //drinkViewModel.insert(drink!!);

        //displayToastValidation("Drink with name '${drink.name}' has been added");

        val intent = Intent(this, AddDrinkActivity::class.java).apply {
            putExtra("newDrink", drink)
            setResult(RESULT_OK, this);
        }

        super.onBackPressed()
    }


    private fun getTabText(position: Int): String {
        var tabText: String = "Details"

        when (position) {
            1 -> tabText = "Ingredients"
        }

        return tabText
    }

    fun getMyIngredients(): ArrayList<IngredientMeasure> {
        return ingredientMeasureList
    }

        companion object {
            const val EXTRA_REPLY = "com.example.android.drinklistsql.REPLY"
        }
    }