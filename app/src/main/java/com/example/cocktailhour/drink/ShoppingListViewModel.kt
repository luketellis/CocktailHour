package com.example.cocktailhour.drink

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cocktailhour.database.CocktailHourRoomDatabase
import com.example.cocktailhour.database.ShoppingListRepository
import com.example.cocktailhour.entitiy.ShoppingList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ShoppingListRepository

    val allShoppingListItems: LiveData<List<ShoppingList>>

    init {

        val shoppingListDao = CocktailHourRoomDatabase.getDatabase(application, viewModelScope).shoppingListDao()
        repository = ShoppingListRepository(shoppingListDao)
        allShoppingListItems = repository.allShoppingListItems
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
   fun insert(shoppingList: ShoppingList) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(shoppingList)
    }

    fun update(shoppingList: ShoppingList) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(shoppingList)
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

    fun deleteByIngredient(ingredient: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteByIngredient(ingredient)
    }

}