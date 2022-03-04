package com.example.myapplication


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.auth.AuthModel

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
            isLoginSuccessLiveData.postValue(Unit)
        } else {
            isLoginFailedLiveData.postValue(Unit)
        }
        hideProgressLiveData.postValue(Unit)

    }
}