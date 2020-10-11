package com.example.cocktailhour.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Drink")
class Drink(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "nameDE") val nameDE: String?,
    @ColumnInfo(name = "tags") val tags: String?,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "alcoholic") val alcoholic: String,
    @ColumnInfo(name = "glass") val glass: String?,
    @ColumnInfo(name = "instructions") val instructions: String,
    @ColumnInfo(name = "instructionsDE") val instructionsDE: String?,
    @ColumnInfo(name = "thumbnail") val thumbnail: String?,
    @ColumnInfo(name = "dateModified") val dateModified: String
) : Parcelable {
    override fun toString(): String {
        return "Drink(id=$id, name='$name', nameDE=$nameDE, tags=$tags, category='$category', alcoholic='$alcoholic', glass=$glass, instructions='$instructions', instructionsDE=$instructionsDE, thumbnail=$thumbnail, dateModified='$dateModified')"
    }
}



