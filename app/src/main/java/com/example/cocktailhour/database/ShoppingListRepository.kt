package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import com.example.cocktailhour.entitiy.ShoppingList


class ShoppingListRepository(private val shoppingListDao: ShoppingListDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
  val allShoppingListItems: LiveData<List<ShoppingList>> = shoppingListDao.getAllShoppingListItems()

   suspend fun insert(shoppingList: ShoppingList) {
        shoppingListDao.insertShoppingListItem(shoppingList)
    }

    fun update(shoppingList: ShoppingList) {
        shoppingListDao.updateShoppingListItem(shoppingList)
    }

    suspend fun deleteByIngredient(ingredient: String) {
        shoppingListDao.deleteShoppingListByIngredient(ingredient)
    }

    suspend fun deleteAll() {
        shoppingListDao.deleteAllShoppingList()
    }
}