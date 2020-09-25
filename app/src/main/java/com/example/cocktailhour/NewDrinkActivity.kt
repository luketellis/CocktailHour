package com.example.cocktailhour

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailhour.database.Drink

class NewDrinkActivity: AppCompatActivity() {

        private lateinit var editDrinkView: EditText

        public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_new_drink)
            editDrinkView = findViewById(R.id.edit_drink)

            val button = findViewById<Button>(R.id.button_save)
            button.setOnClickListener {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(editDrinkView.text)) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val drink = Drink(editDrinkView.text.toString(),"category",
                        "Mug", "instructions", "thumbnail")
                    replyIntent.putExtra(EXTRA_REPLY, drink)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                finish()
            }
        }

        companion object {
            const val EXTRA_REPLY = "com.example.android.drinklistsql.REPLY"
        }
    }