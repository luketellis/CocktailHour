package com.example.cocktailhour.entitiy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IngredientMeasure(var ingredient: String, var measure: String) : Parcelable