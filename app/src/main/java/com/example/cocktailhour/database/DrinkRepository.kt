package com.example.cocktailhour.database

import androidx.lifecycle.LiveData


class DrinkRepository(private val drinkDao: DrinkDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allDrinks: LiveData<List<Drink>> = drinkDao.getAlphabetizedDrink()

    suspend fun insert(drink: Drink) {
        drinkDao.insertDrink(drink)
    }

    suspend fun deleteById(id: Int) {
        drinkDao.deleteDrinkById(id)
    }

    suspend fun delete() {
        drinkDao.deleteAllDrinks()
    }
}