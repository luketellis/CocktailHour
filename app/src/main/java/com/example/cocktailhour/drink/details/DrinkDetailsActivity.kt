package com.example.cocktailhour.drink.details

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.cocktailhour.R
import com.example.cocktailhour.database.Drink
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DrinkDetailsActivity : AppCompatActivity() {
    private var  drink: Drink? = null

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

        val viewPager2 = findViewById<ViewPager2>(R.id.pager2_container)

        val fragmentList = arrayListOf(
            DetailsFragment.newInstance(),
            IngredientFragment.newInstance(),
            GalleryFragment.newInstance()
        )
        viewPager2.adapter = ViewPagerAdapter(this, fragmentList)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()


    }

    fun getMyData(): Drink? {
        return drink
    }
}