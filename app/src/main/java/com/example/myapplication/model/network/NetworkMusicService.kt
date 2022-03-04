package com.example.myapplication.model

interface NetworkMusicService{
    fun getFavouriteMusic(): List<Any>
    fun updateFavouriteMusic(data: Any)

}