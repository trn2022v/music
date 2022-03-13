package com.example.myapplication.ui.music

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

class MusicViewModel: ViewModel(),LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event){
            Lifecycle.Event.ON_CREATE->{

            }
        }
    }

}