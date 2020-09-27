package com.example.cocktailhour

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailhour.database.Drink

class DrinkDetailsActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var tagsTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var alcoholicTextView: TextView
    private lateinit var glassTextView: TextView
    private lateinit var instructionsTextView: TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drink_details_activity)

        nameTextView = findViewById(R.id.nameText)
        tagsTextView = findViewById(R.id.tags)
        categoryTextView = findViewById(R.id.category)
        alcoholicTextView = findViewById(R.id.alcoholic)
        glassTextView = findViewById(R.id.glass)
        instructionsTextView = findViewById(R.id.instructions)

        val drink = intent.getParcelableExtra<Drink>("drink")

        nameTextView.text = drink?.name
        tagsTextView.text = drink?.tags
        categoryTextView.text = drink?.category
        alcoholicTextView.text = drink?.alcoholic
        glassTextView.text = drink?.glass
        instructionsTextView.text = drink?.instructions

        val button = findViewById<Button>(R.id.button_save)
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
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.drinklistsql.REPLY"
    }
}