package com.example.cocktailhour.ui.recipes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.drink.add.AddDrinkActivity
import com.example.cocktailhour.drink.DrinkListAdapter
import com.example.cocktailhour.drink.DrinkViewModel
import com.example.cocktailhour.drink.details.DrinkDetailsActivity
import com.example.cocktailhour.entitiy.Drink
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecipesFragment : Fragment() {

    private val newDrinkActivityRequestCode = 1
    private lateinit var drinkViewModel: DrinkViewModel
    private lateinit var recipesViewModel: RecipesViewModel

    private var twoIngredientsSet: Boolean = false;


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recipesViewModel =
                ViewModelProviders.of(this).get(RecipesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recipes, container, false)
        recipesViewModel.text.observe(viewLifecycleOwner, Observer {
        })

        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)


        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = DrinkListAdapter(root.context, drinkViewModel) { showDetail(it)}
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)

        drinkViewModel.allDrinks.observe(viewLifecycleOwner, Observer { drinks ->
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

        val fab = root.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(activity, AddDrinkActivity::class.java)
            startActivityForResult(intent, newDrinkActivityRequestCode)
        }

        return root
    }

    private fun showDetail(item: Drink) {
        val intent = Intent(activity, DrinkDetailsActivity::class.java)
        intent.putExtra("drink", item)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newDrinkActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getParcelableExtra<Drink>("newDrink")?.let {
                val drink = it

                drinkViewModel.insert(it)
            }
        } else {
            Toast.makeText(activity, R.string.empty_not_saved, Toast.LENGTH_LONG).show()
        }
    }

}