package com.example.myapplication.model.network

interface NetworkMusicService{
    fun getFavouriteMusic(): List<Any>
    fun updateFavouriteMusic(data: Any)

}