package com.example.cocktailhour.drink.add


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Ingredient
import com.example.cocktailhour.entitiy.IngredientDTO

class AddIngredientFragment: Fragment(), TextWatcher {
    private lateinit var ingredientOneEditText: EditText
    private lateinit var ingredientTwoEditText: EditText
    private lateinit var ingredientThreeEditText: EditText
    private lateinit var ingredientFourEditText: EditText
    private lateinit var ingredientFiveEditText: EditText
    private lateinit var ingredientSixEditText: EditText

    private lateinit var measureOneEditText: EditText
    private lateinit var measureTwoEditText: EditText
    private lateinit var measureThreeEditText: EditText
    private lateinit var measureFourEditText: EditText
    private lateinit var measureFiveEditText: EditText
    private lateinit var measureSixEditText: EditText

    private var newIngredient : IngredientDTO = IngredientDTO()

    private var parentActivity: AddDrinkActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.add_ingredient_fragment, container, false)

        parentActivity = activity as AddDrinkActivity?

        ingredientOneEditText = root.findViewById(R.id.ingredientOneEditText)
        ingredientOneEditText.addTextChangedListener(this)

        ingredientTwoEditText = root.findViewById(R.id.ingredientTwoEditText)
        ingredientTwoEditText.addTextChangedListener(this)

        ingredientThreeEditText = root.findViewById(R.id.ingredientThreeEditText)
        ingredientThreeEditText.addTextChangedListener(this)

        ingredientFourEditText = root.findViewById(R.id.ingredientFourEditText)
        ingredientFourEditText.addTextChangedListener(this)

        ingredientFiveEditText = root.findViewById(R.id.ingredientFiveEditText)
        ingredientFiveEditText.addTextChangedListener(this)

        ingredientSixEditText = root.findViewById(R.id.ingredientSixEditText)
        ingredientSixEditText.addTextChangedListener(this)

        measureOneEditText = root.findViewById(R.id.measureOneEditText)
        measureOneEditText.addTextChangedListener(this)

        measureTwoEditText = root.findViewById(R.id.measureTwoEditText)
        measureTwoEditText.addTextChangedListener(this)

        measureThreeEditText = root.findViewById(R.id.measureThreeEditText)
        measureThreeEditText.addTextChangedListener(this)

        measureFourEditText = root.findViewById(R.id.measureFourEditText)
        measureFourEditText.addTextChangedListener(this)

        measureFiveEditText = root.findViewById(R.id.measureFiveEditText)
        measureFiveEditText.addTextChangedListener(this)

        measureSixEditText = root.findViewById(R.id.measureSixEditText)
        measureSixEditText.addTextChangedListener(this)

        return root
    }

    companion object{
        fun newInstance() = AddIngredientFragment()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
        when (s.hashCode()) {
            ingredientOneEditText.text.hashCode() -> newIngredient.ingredient1 = s.toString()
            ingredientTwoEditText.text.hashCode() ->  newIngredient.ingredient2 = s.toString()
            ingredientThreeEditText.text.hashCode() -> newIngredient.ingredient3 = s.toString()
            ingredientFourEditText.text.hashCode() ->  newIngredient.ingredient4 = s.toString()
            ingredientFiveEditText.text.hashCode() -> newIngredient.ingredient5 = s.toString()
            ingredientSixEditText.text.hashCode() ->  newIngredient.ingredient6 = s.toString()

            measureOneEditText.text.hashCode() -> newIngredient.measure1 = s.toString()
            measureTwoEditText.text.hashCode() -> newIngredient.measure2 = s.toString()
            measureThreeEditText.text.hashCode() -> newIngredient.measure3 = s.toString()
            measureFourEditText.text.hashCode() -> newIngredient.measure4 = s.toString()
            measureFiveEditText.text.hashCode() -> newIngredient.measure5 = s.toString()
            measureSixEditText.text.hashCode() -> newIngredient.measure6 = s.toString()
        }

        parentActivity?.updateIngredientInActivity(newIngredient)
    }

    override fun afterTextChanged(s: Editable?) {
    }
}
