package com.example.myapplication.utils

import androidx.core.util.PatternsCompat

fun String?.isEmailValid(): Boolean {
    return if (this != null && this.isNotBlank()) {
        isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()
    } else {
        false
    }
}

fun String?.isPasswordValid(): Boolean {
    return if (this != null && this.isNotBlank()) {
        isNotBlank() && this.length > 5
    } else {
        false
    }
}