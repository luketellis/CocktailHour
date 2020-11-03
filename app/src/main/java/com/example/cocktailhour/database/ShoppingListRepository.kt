package com.example.cocktailhour.database

import androidx.lifecycle.LiveData
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.ShoppingList


class ShoppingListRepository(private val shoppingListDao: ShoppingListDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allShoppingListItem: LiveData<List<ShoppingList>> = shoppingListDao.getAllShoppingListItems()

    suspend fun insert(shoppingList: ShoppingList) {
        shoppingListDao.insertShoppingListItem(shoppingList)
    }

    fun update(shoppingList: ShoppingList) {
        shoppingListDao.updateShoppingListItem(shoppingList)
    }

    suspend fun deleteById(ingredient: String) {
        shoppingListDao.deleteShoppingListByIngredient(ingredient)
    }

    suspend fun delete() {
        shoppingListDao.deleteAllShoppingList()
    }
}