package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.DrinkLocation


class DrinkLocationRepository(private val drinkLocationDao: DrinkLocationDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allDrinks: LiveData<List<DrinkLocation>> = drinkLocationDao.getAllDrinkLocationsById()

    suspend fun insert(drinkLocation: DrinkLocation) {
        drinkLocationDao.insertDrinkLocation(drinkLocation)
    }

    fun update(drinkLocation: DrinkLocation) {
        drinkLocationDao.updateDrinkLocation(drinkLocation)
    }

    suspend fun deleteById(id: Int) {
        drinkLocationDao.deleteDrinkLocationById(id)
    }

    suspend fun delete() {
        drinkLocationDao.deleteAllDrinkLocations()
    }
}