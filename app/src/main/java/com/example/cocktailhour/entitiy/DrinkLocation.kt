package com.example.cocktailhour.entitiy

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "DrinkLocation")
class DrinkLocation(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int?,
    @ColumnInfo(name = "country") var country: String,
    @ColumnInfo(name = "drinkName") var drinkName: String,
    @ColumnInfo(name = "latitude") var latitude: Float,
    @ColumnInfo(name = "longitude") var longitude: Float
) : Parcelable {
    override fun toString(): String {
        return "DrinkLocation(id=$id, country='$country', drinkName=$drinkName, latitude=$latitude, longitude=$longitude)"
    }
}



