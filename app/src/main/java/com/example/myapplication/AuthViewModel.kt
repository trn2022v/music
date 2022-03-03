package com.example.myapplication


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()


    private val authModel = AuthModel()


    fun onLoginClicked(email: String, password: String) {

        val isSuccess = authModel.onLoginClicked(email, password)

        showProgressLiveData.postValue(Unit)
        if (isSuccess) {
            isLoginFailedLiveData.postValue(Unit)
        } else {
            isLoginFailedLiveData.postValue(Unit)
        }
        hideProgressLiveData.postValue(Unit)

    }
}