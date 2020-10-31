package com.example.cocktailhour.drink.edit


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Ingredient
import com.example.cocktailhour.entitiy.IngredientMeasure


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

    var ingredientMeasureOne : IngredientMeasure? = null
    var ingredientMeasureTwo : IngredientMeasure? = null
    var ingredientMeasureThree : IngredientMeasure? = null
    var ingredientMeasureFour : IngredientMeasure? = null
    var ingredientMeasureFive : IngredientMeasure? = null
    var ingredientMeasureSix : IngredientMeasure? = null

    val list: MutableList<IngredientMeasure> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.add_ingredient_fragment, container, false)

/*        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)*/
        /*val drink: Drink? = activity?.getMyDrink()*/

        ingredientOneEditText = root.findViewById(R.id.ingredientOneEditText)
        ingredientOneEditText.addTextChangedListener(this)
        ingredientTwoEditText = root.findViewById(R.id.ingredientTwoEditText)
        ingredientTwoEditText.addTextChangedListener(this)
        ingredientThreeEditText = root.findViewById(R.id.ingredientThreeEditText)
        ingredientFourEditText = root.findViewById(R.id.ingredientFourEditText)
        ingredientFiveEditText = root.findViewById(R.id.ingredientFiveEditText)
        ingredientSixEditText = root.findViewById(R.id.ingredientSixEditText)

        measureOneEditText = root.findViewById(R.id.measureOneEditText)
        measureTwoEditText = root.findViewById(R.id.measureTwoEditText)
        measureThreeEditText = root.findViewById(R.id.measureThreeEditText)
        measureFourEditText = root.findViewById(R.id.measureFourEditText)
        measureFiveEditText = root.findViewById(R.id.measureFiveEditText)
        measureSixEditText = root.findViewById(R.id.measureSixEditText)


        ingredientOneEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                setupIngredientMeasureArray()
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })




        val activity: EditDrinkActivity? = activity as EditDrinkActivity?

/*        val adapter = IngredientMeasureListAdapter(root.context, activity!!.getMyIngredients())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)*/

        return root;
    }


    fun setupIngredientMeasureArray() {

        var ingredientMeasureList = IngredientMeasure(
            ingredientOneEditText.text.toString(),
            measureOneEditText.text.toString()
        )

        list.add(
            IngredientMeasure(
                ingredientOneEditText.text.toString(),
                measureOneEditText.text.toString()
            )
        )
        list.add(
            IngredientMeasure(
                ingredientTwoEditText.text.toString(),
                measureTwoEditText.text.toString()
            )
        )
        list.add(
            IngredientMeasure(
                ingredientThreeEditText.text.toString(),
                measureThreeEditText.text.toString()
            )
        )
        list.add(
            IngredientMeasure(
                ingredientFourEditText.text.toString(),
                measureFourEditText.text.toString()
            )
        )
        list.add(
            IngredientMeasure(
                ingredientFiveEditText.text.toString(),
                measureFiveEditText.text.toString()
            )
        )
        list.add(
            IngredientMeasure(
                ingredientSixEditText.text.toString(),
                measureSixEditText.text.toString()
            )
        )


    }
/*    editTextSample.addTextChangedListener(object : TextWatcher {

        override fun afterTextChanged(s: Editable) {}

        override fun beforeTextChanged(s: CharSequence, start: Int,
                                       count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
        }
    })*/

    companion object{
        fun newInstance() = EditIngredientFragment()
    }

    private fun convertIngredientRecordIntoIngredientMeasureList(ingredient: Ingredient?): ArrayList<IngredientMeasure> {
        val ingredientMeasureList = ArrayList<IngredientMeasure>()




        return ingredientMeasureList
    }

    override fun beforeTextChanged(editable: CharSequence?, p1: Int, p2: Int, p3: Int) {
        Toast.makeText(context, editable, Toast.LENGTH_LONG).show()

        TODO("Not yet implemented")
    }

    override fun onTextChanged(editable: CharSequence?, p1: Int, p2: Int, p3: Int) {
        Toast.makeText(context, editable, Toast.LENGTH_LONG).show()
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(editable: Editable?) {
        Toast.makeText(context, editable, Toast.LENGTH_LONG).show()
/*        when (v.getId()) {
            R.id.oneButton -> {
            }
            R.id.twoButton -> {
            }
            R.id.threeButton -> {
            }
            else -> {
            }
        }*/
    }

/*    ingredientOneEditText.addTextChangedListener(object : TextWatcher {

        override fun afterTextChanged(s: Editable) {
            setupIngredientMeasureArray()
        }

        override fun beforeTextChanged(
            s: CharSequence, start: Int,
            count: Int, after: Int
        ) {
        }

        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
        }
    })*/
}
