package com.example.cocktailhour

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailhour.database.Drink

class DrinkFilterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var tagsEditText: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_details)

        nameEditText = findViewById(R.id.nameTV)
        tagsEditText = findViewById(R.id.tagsTV)

        val drink = intent.getParcelableExtra<Drink>("drink")

        nameEditText.setText(drink?.name)
        tagsEditText.setText(drink?.tags)

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