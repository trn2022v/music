package com.example.myapplication.utils.extensions

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<Unit>?.call() {
    this?.postValue(Unit)
}