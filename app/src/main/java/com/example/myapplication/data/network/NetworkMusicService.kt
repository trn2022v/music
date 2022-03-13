package com.example.myapplication.data.network

interface NetworkMusicService {
    fun getFavouriteMusic(): List<Any>
    fun updateFavouriteMusic(data: Any)

}