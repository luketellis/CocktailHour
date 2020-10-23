package com.example.cocktailhour.drink.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.IngredientMeasure

class IngredientMeasureListAdapter(
    private val context: Context,
    private val data: ArrayList<IngredientMeasure>
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
        private val measurementTV: TextView = v.findViewById(R.id.measurementTV)
        private val imageView = v.findViewById<ImageView>(R.id.imageView)

        fun bind(item: IngredientMeasure) {
            ingredientTV.text = item.ingredient
            measurementTV.text = item.measure

            v.setOnClickListener {
                Toast.makeText(v.context, item.toString(), Toast.LENGTH_SHORT).show()
            }

            v.setOnLongClickListener {
/*                listener(item)*/
                true
            }
        }
    }
}