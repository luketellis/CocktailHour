package com.example.cocktailhour.drink.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cocktailhour.R
import com.example.cocktailhour.database.Drink

class DetailsFragment : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var tagsTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var alcoholicTextView: TextView
    private lateinit var glassTextView: TextView
    private lateinit var instructionsTextView: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_drink_details, container, false)

        nameTextView = root.findViewById(R.id.nameTV)
        tagsTextView = root.findViewById(R.id.tagsTV)
        categoryTextView = root.findViewById(R.id.categoryTV)
        alcoholicTextView = root.findViewById(R.id.alcoholicTV)
        glassTextView = root.findViewById(R.id.glassTV)
        instructionsTextView = root.findViewById(R.id.instructionsTV)

        val activity: DrinkDetailsActivity? = activity as DrinkDetailsActivity?
        val drink: Drink? = activity?.getMyData()

        nameTextView.text = drink?.name
        tagsTextView.text = drink?.tags
        categoryTextView.text = drink?.category
        alcoholicTextView.text = drink?.alcoholic
        glassTextView.text = drink?.glass
        instructionsTextView.text = drink?.instructions

        val button = root.findViewById<Button>(R.id.button_save)

        return root
    }

    companion object{
        fun newInstance() = DetailsFragment()
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
