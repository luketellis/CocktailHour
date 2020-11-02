package com.example.cocktailhour.drink.edit


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


class EditIngredientFragment: Fragment(), TextWatcher {
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
    private var parentActivity: EditDrinkActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.add_ingredient_fragment, container, false)

        parentActivity = activity as EditDrinkActivity?
        val originalIngredient: Ingredient? = parentActivity?.getMyIngredient()

        ingredientOneEditText = root.findViewById(R.id.ingredientOneEditText)
        ingredientOneEditText.addTextChangedListener(this)
        ingredientOneEditText.setText(originalIngredient?.ingredient1)

        ingredientTwoEditText = root.findViewById(R.id.ingredientTwoEditText)
        ingredientTwoEditText.addTextChangedListener(this)
        ingredientTwoEditText.setText(originalIngredient?.ingredient2)

        ingredientThreeEditText = root.findViewById(R.id.ingredientThreeEditText)
        ingredientThreeEditText.addTextChangedListener(this)
        ingredientThreeEditText.setText(originalIngredient?.ingredient3)

        ingredientFourEditText = root.findViewById(R.id.ingredientFourEditText)
        ingredientFourEditText.addTextChangedListener(this)
        ingredientFourEditText.setText(originalIngredient?.ingredient4)

        ingredientFiveEditText = root.findViewById(R.id.ingredientFiveEditText)
        ingredientFiveEditText.addTextChangedListener(this)
        ingredientFiveEditText.setText(originalIngredient?.ingredient5)

        ingredientSixEditText = root.findViewById(R.id.ingredientSixEditText)
        ingredientSixEditText.addTextChangedListener(this)
        ingredientSixEditText.setText(originalIngredient?.ingredient6)

        measureOneEditText = root.findViewById(R.id.measureOneEditText)
        measureOneEditText.addTextChangedListener(this)
        measureOneEditText.setText(originalIngredient?.measure1)

        measureTwoEditText = root.findViewById(R.id.measureTwoEditText)
        measureTwoEditText.addTextChangedListener(this)
        measureTwoEditText.setText(originalIngredient?.measure2)

        measureThreeEditText = root.findViewById(R.id.measureThreeEditText)
        measureThreeEditText.addTextChangedListener(this)
        measureThreeEditText.setText(originalIngredient?.measure3)

        measureFourEditText = root.findViewById(R.id.measureFourEditText)
        measureFourEditText.addTextChangedListener(this)
        measureFourEditText.setText(originalIngredient?.measure4)

        measureFiveEditText = root.findViewById(R.id.measureFiveEditText)
        measureFiveEditText.addTextChangedListener(this)
        measureFiveEditText.setText(originalIngredient?.measure5)

        measureSixEditText = root.findViewById(R.id.measureSixEditText)
        measureSixEditText.addTextChangedListener(this)
        measureSixEditText.setText(originalIngredient?.measure6)

        return root
    }

    companion object{
        fun newInstance() = EditIngredientFragment()
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

