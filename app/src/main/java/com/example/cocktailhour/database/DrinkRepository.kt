package com.example.cocktailhour.database

import androidx.lifecycle.LiveData


class DrinkRepository(private val drinkDao: DrinkDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allDrinks: LiveData<List<Drink>> = drinkDao.getAlphabetizedDrinks()

    suspend fun insert(drink: Drink) {
        drinkDao.insert(drink)
    }
}