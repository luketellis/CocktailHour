package com.example.cocktailhour.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "ingredient")
class Ingredient(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "ingredient1") val ingredient1: String,
    @ColumnInfo(name = "ingredient2") val ingredient2: String,
    @ColumnInfo(name = "ingredient3") val ingredient3: String?,
    @ColumnInfo(name = "ingredient4") val ingredient4: String?,
    @ColumnInfo(name = "ingredient5") val ingredient5: String?,
    @ColumnInfo(name = "ingredient6") val ingredient6: String?,
    @ColumnInfo(name = "ingredient7") val ingredient7: String?,
    @ColumnInfo(name = "measure1") val measure1: String,
    @ColumnInfo(name = "measure2") val measure2: String,
    @ColumnInfo(name = "measure3") val measure3: String?,
    @ColumnInfo(name = "measure4") val measure4: String?,
    @ColumnInfo(name = "measure5") val measure5: String?,
    @ColumnInfo(name = "measure6") val measure6: String?,
    @ColumnInfo(name = "measure7") val measure7: String?
) : Parcelable



