package com.example.myapplication.ui.auth.activity


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.NetworkAuthServiceImpl
import com.example.myapplication.model.LocalStorageModel
import com.example.myapplication.model.NetworkAuthService

class AuthViewModel : ViewModel() {

    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()


    private val authModel: NetworkAuthService = NetworkAuthServiceImpl()
    private val storageModel = LocalStorageModel()


    fun onLoginClicked(email: String, password: String) {

        val token = authModel.onLoginClicked(email, password)

        showProgressLiveData.postValue(Unit)
        if (token != null) {
            storageModel.saveToken(token)
            isLoginSuccessLiveData.postValue(Unit)

        } else {
            isLoginFailedLiveData.postValue(Unit)
        }
        hideProgressLiveData.postValue(Unit)

    }
}