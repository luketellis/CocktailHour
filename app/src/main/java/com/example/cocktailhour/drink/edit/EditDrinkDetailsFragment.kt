package com.example.cocktailhour.drink.edit


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Drink

class EditDrinkDetailsFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var tagsEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var alcoholicEditText: EditText
    private lateinit var glassEditText: EditText
    private lateinit var instructionsEditText: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val root = inflater.inflate(R.layout.activity_drink_edit, container, false)

        val activity: EditDrinkActivity? = activity as EditDrinkActivity?
        val drink: Drink? = activity?.getMyDrink()

        nameEditText = root.findViewById(R.id.nameEditText)
        tagsEditText = root.findViewById(R.id.tagsEditText)
        categoryEditText = root.findViewById(R.id.categoryEditText)
        glassEditText = root.findViewById(R.id.glassEditText)
        instructionsEditText = root.findViewById(R.id.instructionsEditText)

        nameEditText.setText(drink?.name)
        tagsEditText.setText(drink?.tags)
        categoryEditText.setText(drink?.category)
        glassEditText.setText(drink?.glass)
        instructionsEditText.setText(drink?.instructions)


        val staticSpinner = root.findViewById(R.id.alcoholicSpinner) as Spinner

        // Create an ArrayAdapter using the alcoholic string array
        val staticAdapter = ArrayAdapter
            .createFromResource(requireContext(), R.array.alcoholic_options, android.R.layout.simple_spinner_item)

        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        staticSpinner.adapter = staticAdapter
        staticSpinner.setSelection(returnSpinnerIndexBasedOnValue(drink?.alcoholic.toString()))

        val updateBtn = root.findViewById<Button>(R.id.updateBtn)
        updateBtn.setOnClickListener {
            validateEmptyFieldsAndUpdateDrink(nameEditText.text.toString(), categoryEditText.text.toString(),
                tagsEditText.text.toString(), instructionsEditText.text.toString(),
                staticSpinner.selectedItem.toString(), glassEditText.text.toString(), activity)
        }

        val exitWithoutSavingBtn = root.findViewById<Button>(R.id.exitBtn)
        exitWithoutSavingBtn.setOnClickListener {
            activity!!.onBackPressed()
        }

        return root
    }

    private fun returnSpinnerIndexBasedOnValue(alcoholic: String): Int {
        return when (alcoholic) {
            "Non-Alcoholic" -> 1
            "Optional" -> 2

            else -> {
                0
            }
        }
    }

    private fun validateEmptyFieldsAndUpdateDrink(name: String, category: String, tags: String,
        instructions: String, alcoholic: String, glass: String, activity: EditDrinkActivity?) {
        if (name == "") {
            Toast.makeText(context, "Name cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (category == "") {
            Toast.makeText(context, "Category cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (instructions == "") {
            Toast.makeText(context, "Instructions cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        activity?.updateDrinkAndReturnToMainMenu(name, category, tags, instructions, alcoholic, glass)
    }


    companion object{
        fun newInstance() = EditDrinkDetailsFragment()
    }
}
