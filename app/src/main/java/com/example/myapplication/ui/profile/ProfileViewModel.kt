package com.example.myapplication.ui.profile

import androidx.lifecycle.*
import com.example.myapplication.data.storage.preferances.AppPreferences

class ProfileViewModel: ViewModel(), LifecycleEventObserver {
    companion object {
        private const val TAG = "ProfileViewModel"
    }

    private var preferences: AppPreferences? = null
    val logoutLiveData = MutableLiveData<Unit>()


    fun logout() {
        preferences?.saveToken("")
        logoutLiveData.value = Unit
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
    }


}