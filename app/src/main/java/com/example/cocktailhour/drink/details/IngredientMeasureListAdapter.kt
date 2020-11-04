package com.example.cocktailhour.drink.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.drink.ShoppingListViewModel
import com.example.cocktailhour.entitiy.IngredientMeasure
import com.example.cocktailhour.entitiy.ShoppingList

class IngredientMeasureListAdapter(
    private val context: Context,
    private val data: ArrayList<IngredientMeasure>,
    private val shoppingListViewModel: ShoppingListViewModel
/*  private val listener: (IngredientMeasure) -> Unit,*/
) : RecyclerView.Adapter<IngredientMeasureListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.ingredient_measure_row, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val ingredientTV: TextView = v.findViewById(R.id.ingredientTV)
        private val measureTV: TextView = v.findViewById(R.id.measureTV)
/*        private val imageView = v.findViewById<ImageView>(R.id.imageView)*/

        fun bind(item: IngredientMeasure) {
            ingredientTV.text = item.ingredient
            measureTV.text = item.measure

            v.setOnClickListener {
                if (item.ingredient!! != "") {
                    Toast.makeText(v.context, item.toString(), Toast.LENGTH_SHORT).show()
                    shoppingListViewModel.insert(ShoppingList(item.ingredient!!, item.measure!!, null))
                }
            }

            v.setOnLongClickListener {
/*                listener(item)*/
                true
            }
        }
    }
}