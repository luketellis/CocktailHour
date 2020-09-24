package com.example.cocktailhour

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/*@Parcelize
@Entity(tableName = "drinks")
data class Drink(@PrimaryKey @ColumnInfo(name = "id")val id: Int, val name: String, val category: String, val glassType: String,
                 val instructions: String, val thumbnailURL: String, val ingredients: List<String>,
                 val measures: List<String> ): Parcelable {
} */

@Entity(tableName = "drink_table")
class Drink(@PrimaryKey @ColumnInfo(name = "name") val name: String)