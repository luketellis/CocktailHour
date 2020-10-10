package com.example.cocktailhour.drink.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R
import com.example.cocktailhour.database.Drink
import com.squareup.picasso.Picasso

class GalleryFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.gallery_fragment, container, false)

        val imageView = root.findViewById<ImageView>(R.id.thumbnail)

        val activity: DrinkDetailsActivity? = activity as DrinkDetailsActivity?
        val drink: Drink? = activity?.getMyData()

        Picasso.get().load(drink?.thumbnail).into(imageView);
        return root
    }

    companion object{
        fun newInstance() = GalleryFragment()
    }
}
