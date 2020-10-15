package com.example.cocktailhour.drink

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.database.DrinkRepository
import com.example.cocktailhour.database.CocktailHourRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrinkViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DrinkRepository
    // Using LiveData and caching what getAlphabetizedDrinks returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allDrinks: LiveData<List<Drink>>

    val favouriteDrinks: LiveData<List<Drink>>

    init {
        val drinksDao = CocktailHourRoomDatabase.getDatabase(application, viewModelScope).drinkDao()
        repository = DrinkRepository(drinksDao)
        allDrinks = repository.allDrinks
        favouriteDrinks = repository.favouriteDrinks
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(drink: Drink) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(drink)
    }

    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        repository.delete()
    }

    fun deleteById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id)
    }
}