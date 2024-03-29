package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import com.example.cocktailhour.entitiy.Drink


class DrinkRepository(private val drinkDao: DrinkDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allDrinks: LiveData<List<Drink>> = drinkDao.getAllDrinksById()

    val favouriteDrinks: LiveData<List<Drink>> = drinkDao.getFavouritedDrink()

    fun getDrinkById(id: Int): LiveData<Drink> {
        return drinkDao.getDrinkById(id)
    }

    suspend fun insert(drink: Drink) {
        drinkDao.insertDrink(drink)
    }

    fun update(drink: Drink) {
        drinkDao.updateDrink(drink)
    }

    suspend fun changeFavouriteById(id: Int) {
        drinkDao.changeFavouriteById(id, 1 - drinkDao.getFavouriteFromDrink(id))
    }

    suspend fun deleteById(id: Int) {
        drinkDao.deleteDrinkById(id)
    }

    suspend fun deleteAllDrinks() {
        drinkDao.deleteAllDrinks()
    }
}