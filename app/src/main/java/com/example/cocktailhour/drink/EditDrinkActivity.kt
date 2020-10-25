package com.example.cocktailhour.drink

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.Drink

class EditDrinkActivity : AppCompatActivity() {

    private lateinit var drinkViewModel: DrinkViewModel;
    private var drink: Drink? = null;

    private lateinit var nameEditText: EditText
    private lateinit var tagsEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var alcoholicEditText: EditText
    private lateinit var glassEditText: EditText
    private lateinit var instructionsEditText: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_edit)

        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)
        drink = intent.getParcelableExtra<Drink>("drink")

        nameEditText = findViewById(R.id.nameEditText)
        tagsEditText = findViewById(R.id.tagsEditText)
        categoryEditText = findViewById(R.id.categoryEditText)
        alcoholicEditText = findViewById(R.id.alcoholicEditText)
        glassEditText = findViewById(R.id.glassEditText)
        instructionsEditText = findViewById(R.id.instructionsEditText)

        nameEditText.setText(drink?.name)
        tagsEditText.setText(drink?.tags)
        categoryEditText.setText(drink?.category)
        alcoholicEditText.setText(drink?.alcoholic)
        glassEditText.setText(drink?.glass)
        instructionsEditText.setText(drink?.instructions)

        val updateBtn = findViewById<Button>(R.id.updateBtn)
        updateBtn.setOnClickListener {
            validateEmptyFieldsAndUpdateDrink()
            onBackPressed()
        }

        val exitWithoutSavingBtn = findViewById<Button>(R.id.exitBtn)
        exitWithoutSavingBtn.setOnClickListener {
            onBackPressed()
        }
    }


    fun validateEmptyFieldsAndUpdateDrink() {
        if (nameEditText?.text.toString() == "") {
            Toast.makeText(this, "Name cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (categoryEditText?.text.toString() == "") {
            Toast.makeText(this, "Category cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (tagsEditText?.text.toString() == "") {
            Toast.makeText(this, "Tags cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        if (instructionsEditText?.text.toString() == "") {
            Toast.makeText(this, "Instructions cannot be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        drink!!.name = nameEditText.text.toString();
        drink!!.category = categoryEditText.text.toString();
        drink!!.alcoholic = alcoholicEditText.text.toString();
        drink!!.tags = tagsEditText.text.toString();
        drink!!.glass = glassEditText.text.toString();
        drink!!.instructions = instructionsEditText.text.toString();

        drinkViewModel.update(drink!!);
    }

}