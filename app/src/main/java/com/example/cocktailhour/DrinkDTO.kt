package com.example.cocktailhour

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinkDTO(val name: String, val category: String ): Parcelable
/*, val glassType: String,
                 val instructions: String, val thumbnailURL: String, val ingredients: List<String>,
                 val measures: List<String> ): Parcelable {
}*/