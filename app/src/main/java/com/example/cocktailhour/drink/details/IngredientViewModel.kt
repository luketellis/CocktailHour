package com.example.cocktailhour.drink.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cocktailhour.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IngredientViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: IngredientRepository
    public lateinit var ingredient: Ingredient

    init {
        val ingredientDao = CocktailHourRoomDatabase.getDatabase(application, viewModelScope).ingredientDao()
        repository = IngredientRepository(ingredientDao)
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun getIngredientById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        ingredient = repository.getIngredientById(id)
    }

    fun deleteById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id)
    }
}