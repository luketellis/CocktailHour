package com.example.cocktailhour.ui.shoppinglist

import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.drink.ShoppingListViewModel
import com.example.cocktailhour.entitiy.ShoppingList

class ShoppingListFragment : Fragment() {

    private lateinit var shoppingListViewModel: ShoppingListViewModel
    private lateinit var shoppingViewModel: ShoppingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        shoppingViewModel =
                ViewModelProviders.of(this).get(ShoppingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_shopping, container, false)
          shoppingViewModel.text.observe(viewLifecycleOwner, Observer {
        })

      shoppingListViewModel = ViewModelProvider(this).get(ShoppingListViewModel::class.java)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ShoppingListAdapter(root.context, shoppingListViewModel) { showDetail(it)}
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)

        shoppingListViewModel.allShoppingListItems.observe(viewLifecycleOwner, Observer { shoppinglist ->
            // Update the cached copy of the shopping list items in the adapter.
            shoppinglist?.let { adapter.setShoppingListItems(it) }
        })



        return root
    }

    private fun showDetail(item: ShoppingList) {
        Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
    }
}