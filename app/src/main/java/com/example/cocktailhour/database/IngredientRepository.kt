package com.example.cocktailhour.database

import com.example.cocktailhour.entitiy.Ingredient


class IngredientRepository(private val ingredientDao: IngredientDao) {

    suspend fun getIngredientById(id: Int): Ingredient {
        return ingredientDao.getIngredientById(id)
    }

    suspend fun insert(ingredient: Ingredient) {
        ingredientDao.insertIngredient(ingredient)
    }

    fun update(ingredient: Ingredient) {
        ingredientDao.updateIngredient(ingredient)
    }

    suspend fun deleteById(id: Int) {
        ingredientDao.deleteIngredientById(id)
    }

    suspend fun delete() {
        ingredientDao.deleteAllIngredients()
    }
}