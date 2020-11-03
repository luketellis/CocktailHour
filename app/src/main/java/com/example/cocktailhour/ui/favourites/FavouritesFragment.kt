package com.example.cocktailhour.ui.favourites

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.drink.DrinkListAdapter
import com.example.cocktailhour.drink.DrinkViewModel
import com.example.cocktailhour.drink.IngredientViewModel
import com.example.cocktailhour.drink.details.DrinkDetailsActivity

class FavouritesFragment : Fragment() {

    private val newDrinkActivityRequestCode = 1
    private lateinit var drinkViewModel: DrinkViewModel
    private lateinit var ingredientViewModel: IngredientViewModel
    private lateinit var favouritesViewModel: FavouritesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        favouritesViewModel =
                ViewModelProviders.of(this).get(FavouritesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favourites, container, false)
        favouritesViewModel.text.observe(viewLifecycleOwner, Observer {
        })

        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)
        ingredientViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = DrinkListAdapter(root.context, drinkViewModel, ingredientViewModel) { showDetail(it)}
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)

        drinkViewModel.favouriteDrinks.observe(viewLifecycleOwner, Observer { drinks ->
            // Update the cached copy of the drinks in the adapter.
            drinks?.let { adapter.setDrinks(it) }
        })

        val searchView: SearchView = root.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
        })


        return root
    }

    private fun showDetail(item: Drink) {
        val intent = Intent(activity, DrinkDetailsActivity::class.java)
        intent.putExtra("drink", item)
        startActivity(intent)
    }
}