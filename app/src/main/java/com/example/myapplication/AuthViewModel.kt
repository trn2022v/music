package com.example.myapplication


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()
    val titleLiveData = MutableLiveData<String>()


    private val authModel = AuthModel()


    fun onLoginClicked(email: String, password: String) {

        val isSuccess = authModel.onLoginClicked(email, password)


        if (isSuccess) {
            isLoginFailedLiveData.postValue(Unit)
        } else {
            isLoginFailedLiveData.postValue(Unit)
        }

    }
}