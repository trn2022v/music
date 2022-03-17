package com.example.myapplication.ui.music

import androidx.lifecycle.*
import com.example.myapplication.data.network.model.artists.Artist
import com.example.myapplication.data.network.service.artists.ArtistsService
import com.example.myapplication.data.storage.preferances.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel : ViewModel(), LifecycleEventObserver {
    companion object {
        private const val TAG = "MusicViewModel"
    }

    private var preferences: AppPreferences? = null
    private var artistsService: ArtistsService? = null

    val artistsLiveData = MutableLiveData<List<Artist>>()
    val logoutLiveData = MutableLiveData<Unit>()

     fun setArtistService(service: ArtistsService) {
        this.artistsService = service
    }

     fun logout() {
        preferences?.saveToken("")
        logoutLiveData.value = Unit
    }

    fun setSharedPreferences(preferences: AppPreferences) {
        this.preferences = preferences
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                getArtists()

            }
        }
    }


    private fun getArtists() {
        viewModelScope.launch(Dispatchers.IO) {
        val artists = artistsService?.getTopArtists()?.artists?.artist ?: listOf()
        artistsLiveData.postValue(artists)
        }
    }
}