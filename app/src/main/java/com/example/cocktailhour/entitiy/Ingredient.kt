package com.example.cocktailhour.entitiy

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "ingredient")
class Ingredient(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int?,
    @ColumnInfo(name = "ingredient1") var ingredient1: String,
    @ColumnInfo(name = "ingredient2") var ingredient2: String,
    @ColumnInfo(name = "ingredient3") var ingredient3: String?,
    @ColumnInfo(name = "ingredient4") var ingredient4: String?,
    @ColumnInfo(name = "ingredient5") var ingredient5: String?,
    @ColumnInfo(name = "ingredient6") var ingredient6: String?,
    @ColumnInfo(name = "ingredient7") var ingredient7: String?,
    @ColumnInfo(name = "measure1") var measure1: String,
    @ColumnInfo(name = "measure2") var measure2: String,
    @ColumnInfo(name = "measure3") var measure3: String?,
    @ColumnInfo(name = "measure4") var measure4: String?,
    @ColumnInfo(name = "measure5") var measure5: String?,
    @ColumnInfo(name = "measure6") var measure6: String?,
    @ColumnInfo(name = "measure7") var measure7: String?
) : Parcelable {
    override fun toString(): String {
        return "Ingredient(id=$id, ingredient1='$ingredient1', ingredient2='$ingredient2', ingredient3=$ingredient3, ingredient4=$ingredient4, ingredient5=$ingredient5, ingredient6=$ingredient6, ingredient7=$ingredient7, measure1='$measure1', measure2='$measure2', measure3=$measure3, measure4=$measure4, measure5=$measure5, measure6=$measure6, measure7=$measure7)"
    }
}



