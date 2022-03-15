package com.example.myapplication.ui.reg

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegViewModel: ViewModel() {
    val emailLifeData = MutableLiveData<String>()
    val passwordLifeData = MutableLiveData<String>()
    val saveCredentialCheckedLifeData = MutableLiveData<Boolean>()
}