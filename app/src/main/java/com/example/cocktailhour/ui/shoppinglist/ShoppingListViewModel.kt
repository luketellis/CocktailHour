package com.example.cocktailhour.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the shopping Fragment"
    }
    val text: LiveData<String> = _text
}