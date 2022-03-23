package com.example.myapplication.ui.auth.sign_in


import androidx.lifecycle.*
import com.example.myapplication.data.local.auth.LocalAuthService
import com.example.myapplication.data.local.auth.LocalAuthServiceI
import com.example.myapplication.data.storage.preferances.AppPreferences
import com.example.myapplication.domain.SignInIteractorI
import com.example.myapplication.utils.extensions.call
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val signInInteractorI: SignInIteractorI) : ViewModel() {

    val showCredentialsErrorLiveData = MutableLiveData<Unit>()
    val signInSuccessLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()

    fun onSignInClicked(email: String, password: String) {
        showProgressLiveData.call()
        viewModelScope.launch(Dispatchers.IO) {
            val isSignInSuccess = signInInteractorI.onSignIn(email, password)

            if (isSignInSuccess) {
                signInSuccessLiveData.call()
            } else {
                showCredentialsErrorLiveData.call()
            }
            hideProgressLiveData.call()
        }
    }
}
