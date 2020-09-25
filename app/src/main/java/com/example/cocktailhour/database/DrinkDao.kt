package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DrinkDao {

    @Query("SELECT * from Drinks ORDER BY name ASC")
    fun getAlphabetizedDrinks(): LiveData<List<Drink>>

    @Query("SELECT count(*) from Drinks")
    fun getNumberOfDrinks(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(drink: Drink)

    @Query("DELETE FROM Drinks")
    suspend fun deleteAll()
}