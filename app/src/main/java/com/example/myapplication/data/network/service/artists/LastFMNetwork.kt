package com.example.myapplication.data.network.service.artists

import com.example.myapplication.data.network.service.albums.AlbumsService

interface LastFMNetwork {
    fun getArtistsService(): ArtistsService
    fun getAlbumsService(): AlbumsService
}