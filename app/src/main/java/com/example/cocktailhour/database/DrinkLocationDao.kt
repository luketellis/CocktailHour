package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cocktailhour.entitiy.DrinkLocation

@Dao
interface DrinkLocationDao {

    @Query("SELECT * FROM DrinkLocation ORDER BY id ASC")
    fun getAllDrinkLocationsById(): LiveData<List<DrinkLocation>>

    @Query("SELECT * FROM DrinkLocation WHERE id = :id")
    fun getDrinkLocationById(id: Int): DrinkLocation

    @Update
    fun updateDrinkLocation(drinkLocation: DrinkLocation)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDrinkLocation(drinkLocation: DrinkLocation)

    @Query("DELETE FROM DrinkLocation WHERE id = :id")
    suspend fun deleteDrinkLocationById(id: Int)

    @Query("DELETE FROM DrinkLocation")
    suspend fun deleteAllDrinkLocations()
}