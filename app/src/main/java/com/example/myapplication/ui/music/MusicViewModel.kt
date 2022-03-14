package com.example.myapplication.ui.music

import androidx.lifecycle.*
import com.example.myapplication.data.storage.preferances.AppPreferences

class MusicViewModel : ViewModel(), LifecycleEventObserver {

    val logoutLiveData = MutableLiveData<Unit>()

    private var preferences: AppPreferences? = null

    fun setSharedPreferences(preferences: AppPreferences) {
        this.preferences = preferences
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
            }
        }
    }

    fun logout() {
        preferences?.saveToken("")
        logoutLiveData.value = Unit
    }
}