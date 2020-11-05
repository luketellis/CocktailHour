package com.example.cocktailhour.drink

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.drink.edit.EditDrinkActivity
import com.example.cocktailhour.entitiy.Drink
import java.util.*
import kotlin.collections.ArrayList


class DrinkListAdapter internal constructor(
    context: Context,
    private val drinkViewModel: DrinkViewModel,
    private val ingredientViewModel: IngredientViewModel,
    private val listener: (Drink) -> Unit
) : RecyclerView.Adapter<DrinkListAdapter.DrinkViewHolder>(), Filterable {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var drinks = emptyList<Drink>() // Cached copy of drinks
    private var filteredDrinks = emptyList<Drink>()


    inner class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val drinkItemView: TextView = itemView.findViewById(R.id.drinkName)
        private val imageView: ImageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(item: Drink) {
            if (item.favourite > 0)
            {
                imageView.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
            }
            else
            {
                imageView.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
            }

            imageView.setOnClickListener()
            {
                drinkViewModel.changeFavouriteById(item.id!!)
            }

            itemView.setOnClickListener { listener(item) }
            itemView.setOnLongClickListener { onLongClick(itemView, item) }
        }

        private fun onLongClick(v: View?, item: Drink): Boolean {
            val pop = PopupMenu(itemView.context, v)
            pop.inflate(R.menu.contextual_menu)

            pop.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_edit -> {
                        val intent = Intent(v?.context, EditDrinkActivity::class.java)
                        intent.putExtra("drink", item)
                        if (v != null) {
                            startActivity(v.context, intent, null)
                        }
                    }

                    R.id.action_delete -> {
                        menuItem?.let {

                            val alert: AlertDialog.Builder = AlertDialog.Builder(itemView.context)
                            alert.setTitle("Delete ${item.name}")
                            alert.setMessage("Are you sure you want to delete this drink?")
                            alert.setPositiveButton("Yes") { dialog, _ ->
                                Toast.makeText(
                                    itemView.context,
                                    "Drink with name \"${item.name}\" has been deleted",
                                    Toast.LENGTH_SHORT
                                ).show()

                                drinkViewModel.deleteById(item.id!!)
                                ingredientViewModel.deleteById(item.id)

                                dialog.dismiss()
                            }

                            alert.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
                            alert.show()
                        }
                    }
                }
                true
            }
            pop.show()

            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val itemView = inflater.inflate(R.layout.drink_row, parent, false)
        return DrinkViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val current = filteredDrinks[position]
        holder.drinkItemView.text = current.name
        holder.bind(current)
    }

    internal fun setDrinks(drinks: List<Drink>) {
        this.drinks = drinks
        this.filteredDrinks = drinks
        notifyDataSetChanged()
    }

    override fun getItemCount() = filteredDrinks.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredDrinks = drinks
                } else {
                    val resultList = ArrayList<Drink>()
                    for (row in drinks) {
                        if (row.name.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filteredDrinks = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredDrinks
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredDrinks = results?.values as ArrayList<Drink>
                notifyDataSetChanged()
            }

        }
    }
}