package com.example.myapplication.ui.reg

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.storage.room.UserDao
import com.example.myapplication.data.storage.room.UserDatabase
import android.content.Context

class RegViewModel: ViewModel() {
    val emailLifeData = MutableLiveData<String>()
    val passwordLifeData = MutableLiveData<String>()
    val saveCredentialCheckedLifeData = MutableLiveData<Boolean>()

}