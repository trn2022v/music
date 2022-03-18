package com.example.myapplication.ui.music

import Albums
import androidx.lifecycle.*
import com.example.myapplication.data.network.model.albums.Album
import com.example.myapplication.data.network.model.artists.Artist
import com.example.myapplication.data.network.service.albums.AlbumsService
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
    private var albumsService: AlbumsService? = null

    val artistsLiveData = MutableLiveData<List<Artist>>()
    val albumsLiveData = MutableLiveData<List<Album>>()
    val logoutLiveData = MutableLiveData<Unit>()

    fun setArtistService(service: ArtistsService) {
        this.artistsService = service
    }

    fun setAlbumsService(service: AlbumsService) {
        this.albumsService = service
    }

    fun logout() {
        preferences?.saveToken("")
        logoutLiveData.value = Unit
    }

    fun setSharedPreferences(preferences: AppPreferences) {
        this.preferences = preferences
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
//        when (event) {
//            Lifecycle.Event.ON_CREATE -> {
                getArtists()
                getAlbums()

//            }
//        }
    }


    private fun getArtists() {
        viewModelScope.launch(Dispatchers.IO) {
            val artists = artistsService?.getTopArtists()?.artists?.artist ?: listOf()
            artistsLiveData.postValue(artists)
        }
    }

    private fun getAlbums() {
        viewModelScope.launch(Dispatchers.IO) {
            val albums = albumsService?.getTopAlbums()?.albums?.album ?: listOf()
            albumsLiveData.postValue(albums)
        }
    }
}