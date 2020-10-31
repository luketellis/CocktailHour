package com.example.cocktailhour.misc

import com.example.cocktailhour.entitiy.IngredientDTO

class Validations {

    companion object {

        fun isOptionalIngredientMeasureComplete(potentialIngredient: IngredientDTO): Boolean {
            if ((potentialIngredient.ingredient3 == null) xor (potentialIngredient.measure3 == null))
                return false

            if ((potentialIngredient.ingredient4 == null) xor (potentialIngredient.measure4 == null))
                return false

            if ((potentialIngredient.ingredient5 == null) xor (potentialIngredient.measure5 == null))
                return false

            if ((potentialIngredient.ingredient6 == null) xor (potentialIngredient.measure6 == null))
                return false

            if ((potentialIngredient.ingredient7 == null) xor (potentialIngredient.measure7 == null))
                return false

            if ((potentialIngredient.ingredient3 == "") xor (potentialIngredient.measure3 == ""))
                return false

            if ((potentialIngredient.ingredient4 == "") xor (potentialIngredient.measure4 == ""))
                return false

            if ((potentialIngredient.ingredient5 == "") xor (potentialIngredient.measure5 == ""))
                return false

            if ((potentialIngredient.ingredient6 == "") xor (potentialIngredient.measure6 == ""))
                return false

            if ((potentialIngredient.ingredient7 == "") xor (potentialIngredient.measure7 == ""))
                return false

            return true
        }

        fun isPotentialIngredientValid(potentialIngredient: IngredientDTO): Boolean {
            if (listOf(potentialIngredient.ingredient1, potentialIngredient.ingredient2,
                    potentialIngredient.measure1, potentialIngredient.measure2).any { it == null || it == "" }
            )
                return false

            return true
        }

    }
}