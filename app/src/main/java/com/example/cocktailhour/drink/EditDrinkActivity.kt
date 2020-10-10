package com.example.cocktailhour.drink

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailhour.R
import com.example.cocktailhour.database.Drink

class EditDrinkActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var tagsEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var alcoholicEditText: EditText
    private lateinit var glassEditText: EditText
    private lateinit var instructionsEditText: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_edit)

        nameEditText = findViewById(R.id.nameTV)
        tagsEditText = findViewById(R.id.tagsTV)
        categoryEditText = findViewById(R.id.categoryTV)
        alcoholicEditText = findViewById(R.id.alcoholicTV)
        glassEditText = findViewById(R.id.glassTV)
        instructionsEditText = findViewById(R.id.instructionsTV)

        val drink = intent.getParcelableExtra<Drink>("drink")


        nameEditText.setText(drink?.name)
        tagsEditText.setText(drink?.tags)
        categoryEditText.setText(drink?.category)
        alcoholicEditText.setText(drink?.alcoholic)
        glassEditText.setText(drink?.glass)
        instructionsEditText.setText(drink?.instructions)

        val exitWithoutSavingBtn = findViewById<Button>(R.id.exitBtn)
        exitWithoutSavingBtn.setOnClickListener {
            onBackPressed()
        }
    }

}