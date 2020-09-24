package com.example.cocktailhour

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrinkViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DrinkRepository
    // Using LiveData and caching what getAlphabetizedDrinks returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allDrinks: LiveData<List<Drink>>

    init {
        val drinksDao = DrinkRoomDatabase.getDatabase(application, viewModelScope).drinkDao()
        repository = DrinkRepository(drinksDao)
        allDrinks = repository.allDrinks
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(drink: Drink) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(drink)
    }
}