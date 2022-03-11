package com.example.myapplication.ui.auth.activity


import androidx.lifecycle.*
import com.example.myapplication.model.network.NetworkAuthServiceImpl
import com.example.myapplication.model.storage.LocalStorageModel
import com.example.myapplication.model.network.NetworkAuthService
import com.example.myapplication.model.storage.UserStorage

class AuthViewModel : ViewModel(), LifecycleEventObserver{

    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()

    val emailLifeData = MutableLiveData<String>()
    val passwordLifeData = MutableLiveData<String>()

    private val authModel: NetworkAuthService = NetworkAuthServiceImpl()
    private val storageModel: UserStorage = LocalStorageModel()


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

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE->{
                println("onCreate")
            }
        }
    }
}