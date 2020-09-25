package com.example.cocktailhour.database

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
@Parcelize
@Entity(tableName = "Drinks")
class Drink(@PrimaryKey @ColumnInfo(name = "name") val name: String, @ColumnInfo(name = "category") val category: String,
            @ColumnInfo(name = "glassType") val glassType: String, @ColumnInfo(name = "instructions") val instructions: String,
            @ColumnInfo(name = "thumbnailURL") val thumbnailURL: String) : Parcelable