package com.example.cocktailhour.entitiy

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Drink")
class ShoppingList(
    @ColumnInfo(name = "ingredient") var ingredient: String,
    @ColumnInfo(name = "measure") var measure: String
) : Parcelable {
    override fun toString(): String {
        return "ShoppingList(ingredient='$ingredient', measure='$measure')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShoppingList

        if (ingredient != other.ingredient) return false
        if (measure != other.measure) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ingredient.hashCode()
        result = 31 * result + measure.hashCode()
        return result
    }
}

