package com.example.cocktailhour.drink.add


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

class AddIngredientFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.add_ingredient_fragment, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        /*val drink: Drink? = activity?.getMyDrink()*/

        val activity: AddDrinkActivity? = activity as AddDrinkActivity?

/*        val adapter = IngredientMeasureListAdapter(root.context, activity!!.getMyIngredients())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)*/

        return root;
    }

    companion object{
        fun newInstance() = AddIngredientFragment()
    }

    private fun convertIngredientRecordIntoIngredientMeasureList(ingredient: Ingredient?): ArrayList<IngredientMeasure> {
        val ingredientMeasureList = ArrayList<IngredientMeasure>()




        return ingredientMeasureList
    }
}
