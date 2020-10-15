package com.example.cocktailhour.database

import com.example.cocktailhour.entitiy.Ingredient


class IngredientRepository(private val ingredientDao: IngredientDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    suspend fun getIngredientById(id: Int): Ingredient {
        return ingredientDao.getIngredientById(id)
    }

    //val ingredient: Ingredient = ingredientDao.getIngredientById()

    //val allDrinks: LiveData<List<Drink>> = drinkDao.getAlphabetizedDrink()

    suspend fun insert(ingredient: Ingredient) {
        ingredientDao.insertIngredient(ingredient)
    }

    suspend fun deleteById(id: Int) {
        ingredientDao.deleteIngredientById(id)
    }

    suspend fun delete() {
        ingredientDao.deleteAllIngredients()
    }
}