package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DrinkDao {

    @Query("SELECT * FROM Drinks ORDER BY name ASC")
    fun getAlphabetizedDrinks(): LiveData<List<Drink>>

    @Query("SELECT * FROM Drinks WHERE category = :category ORDER BY name ASC")
    fun getDrinkByCategory(category: String): LiveData<List<Drink>>

    @Update
    fun updateDrink(drink: Drink)

    @Query("SELECT count(*) from Drinks")
    fun getNumberOfDrinks(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDrink(drink: Drink)

    @Query("DELETE FROM Drinks WHERE id = :id")
    suspend fun deleteDrinkById(id: Int)

    @Query("DELETE FROM Drinks")
    suspend fun deleteAllDrinks()
}