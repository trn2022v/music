package com.example.myapplication.ui.music

import androidx.lifecycle.*
import com.example.myapplication.data.storage.preferances.AppPreferences

class MusicViewModel : ViewModel(), LifecycleEventObserver {
    companion object {
        private const val TAG = "ListViewModel"
    }

    private var preferences: AppPreferences? = null

    val logoutLiveData = MutableLiveData<Unit>()

    fun setSharedPreferences(preferences: AppPreferences) {
        this.preferences = preferences
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                println("start")
            }
        }
    }

    fun logout() {
        preferences?.saveToken("")
        logoutLiveData.value = Unit
    }
}