package com.example.cocktailhour.drink.add


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R


class AddDrinkDetailsFragment : Fragment() {

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

        val root = inflater.inflate(R.layout.add_details_fragment, container, false)

        val activity: AddDrinkActivity? = activity as AddDrinkActivity?

        nameEditText = root.findViewById(R.id.nameEditText)
        tagsEditText = root.findViewById(R.id.tagsEditText)
        categoryEditText = root.findViewById(R.id.categoryEditText)
        alcoholicEditText = root.findViewById(R.id.alcoholicEditText)
        glassEditText = root.findViewById(R.id.glassEditText)
        instructionsEditText = root.findViewById(R.id.instructionsEditText)

        instructionsEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                instructionsEditText.requestFocusFromTouch()
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
                instructionsEditText.requestFocusFromTouch()
            }

            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int, count: Int) {
                instructionsEditText.requestFocusFromTouch()
            }
        })


        val addBtn = root.findViewById<Button>(R.id.addBtn)
        addBtn.setOnClickListener {

            var name: String = nameEditText.text.toString()

            validateFieldsAndAddDrink(nameEditText.text.toString(),
                tagsEditText.text.toString(),
                tagsEditText.text.toString(),
                instructionsEditText.text.toString(),
                alcoholicEditText.text.toString(),
                glassEditText.text.toString(),
                activity)

        }

        val exitWithoutSavingBtn = root.findViewById<Button>(R.id.exitBtn)
        exitWithoutSavingBtn.setOnClickListener {
            activity!!.onBackPressed()
        }

        return root
    }

    private fun validateFieldsAndAddDrink(
        name: String,
        category: String,
        tags: String,
        instructions: String,
        alcoholic: String,
        glass: String,
        activity: AddDrinkActivity?
    ) {
        if (name == "") {
            Toast.makeText(context, "Name cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (category == "") {
            Toast.makeText(context, "Category cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (tags == "") {
            Toast.makeText(context, "Tags cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (instructions == "") {
            Toast.makeText(context, "Instructions cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        activity?.addDrinkAndReturnToMainMenu(name, category, tags, instructions, alcoholic, glass)
    }




    companion object{
        fun newInstance() = AddDrinkDetailsFragment()
    }
}

