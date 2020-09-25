package com.example.cocktailhour.entitiy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinkDTO(val name: String, val category: String, val glassType: String,
                 val instructions: String, val thumbnailURL: String) : Parcelable /*val ingredients: List<String>,
                 val measures: List<String> )
}*/