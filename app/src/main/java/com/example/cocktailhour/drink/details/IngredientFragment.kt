package com.example.cocktailhour.drink.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R

class IngredientFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ingredient_fragment, container, false)
    }

    companion object{
        fun newInstance() = IngredientFragment()
    }
}
