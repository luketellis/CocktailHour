package com.example.cocktailhour

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailhour.database.Drink

class DrinkEditActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var tagsEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var alcoholicEditText: EditText
    private lateinit var glassEditText: EditText
    private lateinit var instructionsEditText: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_edit)

        nameEditText = findViewById(R.id.nameText)
        tagsEditText = findViewById(R.id.tags)
        categoryEditText = findViewById(R.id.category)
        alcoholicEditText = findViewById(R.id.alcoholic)
        glassEditText = findViewById(R.id.glass)
        instructionsEditText = findViewById(R.id.instructions)

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