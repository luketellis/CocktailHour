package com.example.cocktailhour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.database.Drink

class DrinkListAdapter internal constructor(
    context: Context,
    private val listener: (Drink) -> Unit
) : RecyclerView.Adapter<DrinkListAdapter.DrinkViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var drinks = emptyList<Drink>() // Cached copy of drinks

    inner class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val drinkItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(item: Drink) {
            itemView.setOnClickListener { listener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
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