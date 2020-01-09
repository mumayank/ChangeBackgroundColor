package com.mumayank.changebackgroundcolor

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorChangeViewModel : ViewModel() {
    val colorResource = MutableLiveData<Int>()
    init {
        colorResource.value = Color.YELLOW
    }
}