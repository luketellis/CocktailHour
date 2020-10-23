package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cocktailhour.entitiy.Drink

@Dao
interface DrinkDao {

    @Query("SELECT * FROM Drink ORDER BY id ASC")
    fun getAllDrinksById(): LiveData<List<Drink>>

    @Query("SELECT * FROM Drink ORDER BY id ASC")
    fun getAllDrinksByName(): LiveData<List<Drink>>

    @Query("SELECT * FROM Drink WHERE id = :id")
    fun getDrinkById(id: Int): Drink

    @Query("SELECT favourite FROM Drink WHERE id = :id")
    fun getFavouriteFromDrink(id: Int): Int

    @Query("SELECT * FROM Drink WHERE name like :searchTerm")
    fun getDrinksByName(searchTerm : String): LiveData<List<Drink>>

    @Query("SELECT * FROM Drink WHERE favourite > 0")
    fun getFavouritedDrink(): LiveData<List<Drink>>

    @Query("SELECT * FROM Drink WHERE category = :category ORDER BY name ASC")
    fun getDrinksByCategory(category: String): LiveData<List<Drink>>

    @Update
    fun updateDrink(drink: Drink)

    @Query("SELECT count(*) from Drink")
    fun getNumberOfDrinks(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDrink(drink: Drink)

    @Query("UPDATE Drink SET favourite = :favourite WHERE id = :id")
    suspend fun changeFavouriteById(id: Int, favourite: Int)

    @Query("DELETE FROM Drink WHERE id = :id")
    suspend fun deleteDrinkById(id: Int)

    @Query("DELETE FROM Drink")
    suspend fun deleteAllDrinks()
}