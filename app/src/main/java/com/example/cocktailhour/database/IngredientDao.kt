package com.example.cocktailhour.database

import androidx.room.*
import com.example.cocktailhour.entitiy.Ingredient

@Dao
interface IngredientDao {
    @Query("SELECT * from ingredient WHERE id = :id")
    fun getIngredientById(id: Int?): Ingredient

    @Update
    fun updateIngredient(ingredient: Ingredient)

    @Query("SELECT count(*) from ingredient")
    fun getNumberOfIngredients(): Int

    @Insert
    suspend fun insertIngredient(ingredient: Ingredient)

    @Query("DELETE FROM ingredient WHERE id = :id")
    suspend fun deleteIngredientById(id: Int)

    @Query("DELETE FROM ingredient")
    suspend fun deleteAllIngredients()
}