package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DrinkDao {

    @Query("SELECT * FROM Drink ORDER BY name ASC")
    fun getAlphabetizedDrink(): LiveData<List<Drink>>

    @Query("SELECT * FROM Drink")
    fun getFavouritedDrink(): LiveData<List<Drink>>

    @Query("SELECT * FROM Drink WHERE category = :category ORDER BY name ASC")
    fun getDrinksByCategory(category: String): LiveData<List<Drink>>

    @Update
    fun updateDrink(drink: Drink)

    @Query("SELECT count(*) from Drink")
    fun getNumberOfDrinks(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDrink(drink: Drink)

    @Query("DELETE FROM Drink WHERE id = :id")
    suspend fun deleteDrinkById(id: Int)

    @Query("DELETE FROM Drink")
    suspend fun deleteAllDrinks()
}