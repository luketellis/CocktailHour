package com.example.cocktailhour.entitiy

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinkLocationDTO(
    var country: String, var coordinates: LatLng, var drink: String) : Parcelable {

    override fun toString(): String {
        return "DrinkLocation(country='$country', coordinates=$coordinates, drink=$drink)"
    }
}