package com.example.cocktailhour

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DrinkDao {

    @Query("SELECT * from Drinks ORDER BY name ASC")
    fun getAlphabetizedDrinks(): LiveData<List<Drink>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(drink: Drink)

    @Query("DELETE FROM Drinks")
    suspend fun deleteAll()
}