package com.example.cocktailhour.drink.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Ingredient
import com.example.cocktailhour.entitiy.IngredientMeasure

class IngredientFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.ingredient_fragment, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        /*val drink: Drink? = activity?.getMyDrink()*/

        val activity: DrinkDetailsActivity? = activity as DrinkDetailsActivity?

        val adapter = IngredientMeasureListAdapter(root.context, activity!!.getMyIngredients())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)

        return root;
    }

    companion object{
        fun newInstance() = IngredientFragment()
    }

    private fun convertIngredientRecordIntoIngredientMeasureList(ingredient: Ingredient?): ArrayList<IngredientMeasure> {
        val ingredientMeasureList = ArrayList<IngredientMeasure>()




        return ingredientMeasureList
    }
}
