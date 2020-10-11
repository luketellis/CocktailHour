package com.example.cocktailhour.entitiy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IngredientMeasure(val ingredient: String, val measure: String) : Parcelable