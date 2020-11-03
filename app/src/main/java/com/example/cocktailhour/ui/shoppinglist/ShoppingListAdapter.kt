package com.example.cocktailhour.ui.shoppinglist

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.ShoppingList
import java.util.*
import kotlin.collections.ArrayList


class ShoppingListAdapter internal constructor(
    context: Context,
    private val shoppingListViewModel: ShoppingListViewModel,
    private val listener: (ShoppingList) -> Unit
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>(), Filterable {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var shoppingList = emptyList<ShoppingList>() // Cached copy of drinks
    private var filteredShoppingList = emptyList<ShoppingList>()


    inner class ShoppingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val shoppingItemView: TextView = itemView.findViewById(R.id.drinkName)

        fun bind(item: ShoppingList) {


            itemView.setOnClickListener { listener(item) }
            itemView.setOnLongClickListener { onLongClick(itemView, item) }
        }

        private fun onLongClick(v: View?, item: ShoppingList): Boolean {
            // Return true to indicate the click was handled

            val pop = PopupMenu(itemView.context, v)
            pop.inflate(R.menu.contextual_menu)

            pop.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_delete -> {
                        menuItem?.let {

                            val alert: AlertDialog.Builder = AlertDialog.Builder(itemView.context)
                            alert.setTitle("Delete ${item.ingredient}")
                            alert.setMessage("Are you sure you want to delete this ingredient?")
                            alert.setPositiveButton("Yes") { dialog, _ ->
                                Toast.makeText(
                                    itemView.context,
                                    "Ingredient with name \"${item.ingredient}\" has been deleted",
                                    Toast.LENGTH_SHORT
                                ).show()

                                //shoppingListViewModel.delet(item.id!!)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        val itemView = inflater.inflate(R.layout.drink_row, parent, false)
        return ShoppingListViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val current = filteredShoppingList[position]
        holder.shoppingItemView.text = current.ingredient
        holder.bind(current)
    }

    internal fun setShoppingListItems(shoppingList: List<ShoppingList>) {
        this.shoppingList = shoppingList
        this.filteredShoppingList = shoppingList
        notifyDataSetChanged()
    }

    override fun getItemCount() = filteredShoppingList.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredShoppingList = shoppingList
                } else {
                    val resultList = ArrayList<ShoppingList>()
                    for (row in shoppingList) {
                        if (row.ingredient?.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filteredShoppingList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredShoppingList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredShoppingList = results?.values as ArrayList<ShoppingList>
                notifyDataSetChanged()
            }

        }
    }
}