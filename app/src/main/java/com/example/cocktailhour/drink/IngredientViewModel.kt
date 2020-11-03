package com.example.cocktailhour.drink

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailhour.database.*
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.Ingredient
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
    fun insert(ingredient: Ingredient) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(ingredient)
    }

    suspend fun getIngredientById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        ingredient = repository.getIngredientById(id)
    }

    fun update(ingredient: Ingredient) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(ingredient)
    }

    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        repository.delete()
    }

    fun deleteById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id)
    }
}