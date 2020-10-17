package com.example.cocktailhour.drink

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Drink


class DrinkListAdapter internal constructor(
    context: Context,
    private val drinkViewModel: DrinkViewModel,
    private val listener: (Drink) -> Unit

) : RecyclerView.Adapter<DrinkListAdapter.DrinkViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var drinks = emptyList<Drink>() // Cached copy of drinks


    inner class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val drinkItemView: TextView = itemView.findViewById(R.id.drinkName)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(item: Drink) {
            if (item.favourite > 0)
            {
                imageView.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
            }

            itemView.setOnClickListener { listener(item) }
            itemView.setOnLongClickListener { onLongClick(itemView, item) }
        }

        private fun onLongClick(v: View?, item: Drink): Boolean {
            // Return true to indicate the click was handled

            val pop = PopupMenu(itemView.context, v)
            pop.inflate(R.menu.contextual_menu)

            pop.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_edit -> {
                        Toast.makeText(itemView.context, "Edit!", Toast.LENGTH_SHORT).show()
                        val intent = Intent (v?.context, EditDrinkActivity::class.java)
                        intent.putExtra("drink", item)
                        if (v != null) {
                            startActivity(v.context, intent, null)
                        }
                    }

                    R.id.action_delete -> {
                        menuItem?.let {
                            Toast.makeText(itemView.context, "Drink with name \"${item.name}\" has been deleted", Toast.LENGTH_SHORT).show()
                            drinkViewModel.deleteById(item.id!!)
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
        val current = drinks[position]
        holder.drinkItemView.text = current.name
        holder.bind(current)
    }

    internal fun setDrinks(drinks: List<Drink>) {
        this.drinks = drinks
        notifyDataSetChanged()
    }

    override fun getItemCount() = drinks.size
}