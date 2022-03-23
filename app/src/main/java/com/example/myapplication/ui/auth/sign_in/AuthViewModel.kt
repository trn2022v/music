package com.example.myapplication.ui.auth.sign_in


import androidx.lifecycle.*
import com.example.myapplication.data.network.service.auth.NetworkAuthServiceImpl
import com.example.myapplication.data.network.service.auth.NetworkAuthService
import com.example.myapplication.data.storage.preferances.AppPreferences

class AuthViewModel : ViewModel(), LifecycleEventObserver {

    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()

    val emailLifeData = MutableLiveData<String>()
    val passwordLifeData = MutableLiveData<String>()
    val saveCredentialCheckedLifeData = MutableLiveData<Boolean>()

    private val authModel: NetworkAuthService = NetworkAuthServiceImpl()

    //    private val storageModel: UserStorage = LocalStorageModel()
    private var preferences: AppPreferences? = null

    fun setSharedPreferences(preferences: AppPreferences) {
        this.preferences = preferences
    }


    fun onLoginClicked(email: String, password: String) {

        val token = authModel.onLoginClicked(email, password)

        showProgressLiveData.postValue(Unit)

        if (token != null) {
            saveToken(token)
            saveCredentials(email, password)
            isLoginSuccessLiveData.postValue(Unit)
        } else {
            isLoginFailedLiveData.postValue(Unit)
        }
        hideProgressLiveData.postValue(Unit)
    }

    fun setSaveCredentialIsSelected(isSelected: Boolean) {
        preferences?.setSaveCredentialIsSelected(isSelected)

    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
    }

    private fun saveCredentials(email: String, password: String) {
        preferences?.let {
            if (it.isSaveCredentialSelected()) {
                it.saveLogin(email)
                it.savePassword(password)
            }

        }
    }

    private fun saveToken(token: String) {
        preferences?.saveToken(token)

    }


    fun fetchStoredData() {
        preferences?.let {
            if (it.isSaveCredentialSelected()) {
                emailLifeData.postValue(it.getLogin())
                passwordLifeData.postValue(it.getPassword())
                saveCredentialCheckedLifeData.postValue(true)
            }

        }

    }

    fun setUpdatedEmail(email: String) {
        if (email != emailLifeData.value) {
            emailLifeData.value = email

        }
    }

    fun setUpdatedPassword(password: String) {
        if (password != passwordLifeData.value) {
            passwordLifeData.value = password
        }

    }

}

