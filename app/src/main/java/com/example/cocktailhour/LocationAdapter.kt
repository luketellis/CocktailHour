package com.example.mytown

import com.example.cocktailhour.database.Drink

class LocationAdapter(private val data: List<Drink>,
                      private val listener: (Drink) -> Unit,)/* : RecyclerView.Adapter<LocationAdapter.ViewHolder>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.layout_row, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: LocationAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val locationRow: TextView = v.findViewById(R.id.number)
        val imageView = v.findViewById<ImageView>(R.id.imageView)

        fun bind(item: Drink) {
            locationRow.text = item.displayAsRow()
            
            var imageResourceId: Int = if (item.countryCapitalCity.equals("Australia/Melbourne"))
                v.resources.getIdentifier("blue_heart_filled", "drawable", v.context.packageName)
            else
                v.resources.getIdentifier("blue_heart_outline", "drawable", v.context.packageName)

            imageView.setBackgroundResource(imageResourceId)

            v.setOnClickListener { Toast.makeText(v.context, item.toString(), Toast.LENGTH_SHORT).show()
                 }

            v.setOnLongClickListener { true }
        }
    }
}*/
