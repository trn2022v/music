package com.example.myapplication.ui.auth.sign_up

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegViewModel: ViewModel() {
    val emailLifeData = MutableLiveData<String>()
    val passwordLifeData = MutableLiveData<String>()
    val saveCredentialCheckedLifeData = MutableLiveData<Boolean>()

}