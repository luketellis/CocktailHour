package com.example.cocktailhour.ui.recipes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.*
import com.example.cocktailhour.database.Drink
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecipesFragment : Fragment() {

    private val newDrinkActivityRequestCode = 1
    private lateinit var drinkViewModel: DrinkViewModel
    private lateinit var recipesViewModel: RecipesViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recipesViewModel =
                ViewModelProviders.of(this).get(RecipesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recipes, container, false)
        val textView: TextView = root.findViewById(R.id.text_recipes)
        recipesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = DrinkListAdapter(root.context)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)

        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)
        drinkViewModel.allDrinks.observe(viewLifecycleOwner, Observer { drinks ->
            // Update the cached copy of the drinks in the adapter.
            drinks?.let { adapter.setDrinks(it) }
        })

        val fab = root.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(activity, NewDrinkActivity::class.java)
            startActivityForResult(intent, newDrinkActivityRequestCode)
        }

        return root
    }


/*    */


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newDrinkActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getParcelableExtra<Drink>(NewDrinkActivity.EXTRA_REPLY)?.let {
                val drink = it

                drinkViewModel.insert(it)
            }
        } else {
            Toast.makeText(activity, R.string.empty_not_saved, Toast.LENGTH_LONG).show()
        }
    }



}