package com.example.cocktailhour.drink.edit


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R

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
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.add_details_fragment, container, false)

        val activity: EditDrinkActivity? = activity as EditDrinkActivity?
        //val drink: Drink? = activity?.getMyDrink()

        nameEditText = root.findViewById(R.id.nameTV)
        tagsEditText = root.findViewById(R.id.tagsTV)
        categoryEditText = root.findViewById(R.id.categoryTV)
        alcoholicEditText = root.findViewById(R.id.alcoholicTV)
        glassEditText = root.findViewById(R.id.glassTV)
        instructionsEditText = root.findViewById(R.id.instructionsTV)

        val addBtn = root.findViewById<Button>(R.id.addBtn)
        addBtn.setOnClickListener {

            var name: String = nameEditText.text.toString()

            validateFieldsAndAddDrink(nameEditText.text.toString(), tagsEditText.text.toString(), tagsEditText.text.toString(),
                instructionsEditText.text.toString(), alcoholicEditText.text.toString(), glassEditText.text.toString(), activity)

        }

        val exitWithoutSavingBtn = root.findViewById<Button>(R.id.exitBtn)
        exitWithoutSavingBtn.setOnClickListener {
            activity!!.onBackPressed()
        }

        return root
    }

    private fun validateFieldsAndAddDrink(name: String, category: String, tags: String, instructions: String, alcoholic: String, glass: String, activity: EditDrinkActivity?) {
        if (name == "") {
            //parentActivity?.displayToastValidation("Name cannot be empty!");
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

        //activity?.addDrink(name, category, tags, instructions, alcoholic, glass)
    }




    companion object{
        fun newInstance() = EditDrinkDetailsFragment()
    }
}

/*           button.setOnClickListener {
               val replyIntent = Intent()
               if (TextUtils.isEmpty(editDrinkView.text)) {
                   setResult(Activity.RESULT_CANCELED, replyIntent)
               } else {
                   val drink = Drink(null, editDrinkView.text.toString(), "German Name", "Tags","category",
                       "Alcoholic","Mug", "instructions", "German Instructions","thumbnail", "12/05/1991")

                   replyIntent.putExtra(EXTRA_REPLY, drink)
                   setResult(Activity.RESULT_OK, replyIntent)
               }
               finish()
           }*/
