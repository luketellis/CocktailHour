package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cocktailhour.entitiy.ShoppingList

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM ShoppingList")
    fun getAllShoppingListItems(): LiveData<List<ShoppingList>>

    @Update
    fun updateShoppingListItem(shoppingList: ShoppingList)

    @Query("SELECT count(*) from ShoppingList")
    fun getNumberOfShoppingListItems(): Int

    @Insert
    suspend fun insertShoppingListItem(shoppingList: ShoppingList)

    @Query("DELETE FROM ShoppingList WHERE ingredient = :ingredient")
    suspend fun deleteShoppingListByIngredient(ingredient: String)

    @Query("DELETE FROM ShoppingList")
    suspend fun deleteAllShoppingList()
}