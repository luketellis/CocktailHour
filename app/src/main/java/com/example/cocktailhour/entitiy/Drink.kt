package com.example.cocktailhour.entitiy

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "Drink")
class Drink(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "nameDE") var nameDE: String?,
    @ColumnInfo(name = "tags") var tags: String?,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "alcoholic") var alcoholic: String,
    @ColumnInfo(name = "glass") var glass: String?,
    @ColumnInfo(name = "instructions") var instructions: String,
    @ColumnInfo(name = "instructionsDE") var instructionsDE: String?,
    @ColumnInfo(name = "thumbnail") var thumbnail: String?,
    @ColumnInfo(name = "dateModified") var dateModified: String,
    @ColumnInfo(name = "favourite") var favourite: Int
) : Parcelable {
    override fun toString(): String {
        return "Drink(id=$id, name='$name', nameDE=$nameDE, tags=$tags, category='$category', " +
                "alcoholic='$alcoholic', glass=$glass, instructions='$instructions', instructionsDE=$instructionsDE, " +
                "thumbnail=$thumbnail, dateModified='$dateModified, favourite='$favourite')"
    }
}



