package com.example.cocktailhour

import com.example.cocktailhour.entitiy.IngredientDTO
import com.example.cocktailhour.misc.Validations
import org.junit.Test
import org.junit.Assert.*


class ValidIngredientTest {

    @Test
    fun dateValidator_AllCorrectVariables_ReturnsTrue() {
        val potentialIngredientDTO = IngredientDTO(1, "Ingredient1", "Ingredient2", "Ingredient3",
            "Ingredient4", "Ingredient5", "Ingredient6", "Ingredient7", "measure1", "measure2",
            "measure3", "measure4", "measure5", "measure6", "measure7")
        assertTrue(Validations.isPotentialIngredientValid(potentialIngredientDTO))
    }

    @Test
    fun dateValidator_FirstTwoIngredientMeasuresCorrectVariables_ReturnsTrue() {
        val potentialIngredientDTO = IngredientDTO(1, "Ingredient1", "Ingredient2", "",
            "", "", "", "", "measure1", "measure2",
            "", "", "", "", "")
        assertTrue(Validations.isPotentialIngredientValid(potentialIngredientDTO))
    }

    @Test
    fun dateValidator_FirstThreeIngredientMeasuresCorrectVariables_ReturnsTrue() {
        val potentialIngredientDTO = IngredientDTO(1, "Ingredient1", "Ingredient2", "Ingredient3",
            "", "", "", "", "measure1", "measure2",
            "measure3", "", "", "", "")
        assertTrue(Validations.isPotentialIngredientValid(potentialIngredientDTO))
    }

    @Test
    fun dateValidator_AllNullVariables_ReturnsFalse() {
        val potentialIngredientDTO = IngredientDTO(null, "", "", null,
            null, null, null, null, "", "",
            null, null, null, null, null)
        assertFalse(Validations.isPotentialIngredientValid(potentialIngredientDTO))    }

    @Test
    fun dateValidator_AllEmptyVariables_ReturnsFalse() {
        val potentialIngredientDTO = IngredientDTO(1, "", "", "",
            "", "", "", "", "", "",
            "", "", "", "", "")
        assertFalse(Validations.isPotentialIngredientValid(potentialIngredientDTO))    }

    @Test
    fun dateValidator_FirstTwoIngredientsAndMeasuresNull_ReturnsFalse() {
        val potentialIngredientDTO = IngredientDTO(1, "", "", "Ingredient3",
            "Ingredient4", "Ingredient5", "Ingredient6", "Ingredient7", "", "",
            "measure3", "measure4", "measure5", "measure6", "measure7")
        assertFalse(Validations.isPotentialIngredientValid(potentialIngredientDTO))
    }

    @Test
    fun dateValidator_FirstTwoIngredientsAndMeasuresEmpty_ReturnsFalse() {
        val potentialIngredientDTO = IngredientDTO(1, "", "", "Ingredient3",
            "Ingredient4", "Ingredient5", "Ingredient6", "Ingredient7", "", "",
            "measure3", "measure4", "measure5", "measure6", "measure7")
        assertFalse(Validations.isPotentialIngredientValid(potentialIngredientDTO))
    }

    @Test
    fun dateValidator_FirstTwoIngredientMeasuresMixOfNullAndEmptyCorrectVariables_ReturnsTrue() {
        val potentialIngredientDTO = IngredientDTO(1, "Ingredient1", "Ingredient2", null,
            "", "", "", "", "measure1", "measure2",
            "", "", "", "", "")
        assertFalse(Validations.isOptionalIngredientMeasureComplete(potentialIngredientDTO))
    }

    @Test
    fun dateValidator_IngredientMissingMeasureEmpty_ReturnsFalse() {
        val potentialIngredientDTO = IngredientDTO(1, "Ingredient1", "Ingredient2", "Ingredient3",
            "Ingredient4", "Ingredient5", "Ingredient6", "Ingredient7", "measure1", "measure2",
            "", "measure4", "measure5", "measure6", "measure7")
        assertFalse(Validations.isOptionalIngredientMeasureComplete(potentialIngredientDTO))
    }

    @Test
    fun dateValidator_IngredientMissingIngredientEmpty_ReturnsFalse() {
        val potentialIngredientDTO = IngredientDTO(1, "Ingredient1", "Ingredient2", "",
            "Ingredient4", "Ingredient5", "Ingredient6", "Ingredient7", "measure1", "measure2",
            "measure3", "measure4", "measure5", "measure6", "measure7")
        assertFalse(Validations.isOptionalIngredientMeasureComplete(potentialIngredientDTO))
    }
}