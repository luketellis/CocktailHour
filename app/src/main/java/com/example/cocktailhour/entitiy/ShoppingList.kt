package com.example.cocktailhour.entitiy

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "ShoppingList")
class ShoppingList(
    @ColumnInfo(name = "ingredient") var ingredient: String,
    @ColumnInfo(name = "measure") var measure: String,
    @PrimaryKey @ColumnInfo(name = "id") val id: Int?,
) : Parcelable {
    override fun toString(): String {
        return "ShoppingList(ingredient='$ingredient', measure='$measure')"
    }

}

