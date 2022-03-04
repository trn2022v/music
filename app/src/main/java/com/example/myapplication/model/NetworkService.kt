package com.example.myapplication.model

interface NetworkAuthService {
    fun onLoginClicked(email: String, password: String): String?
    fun updateUserData(data: Any)
}
    interface NetworkMusicService{
    fun getFavouriteMusic(): List<Any>
    fun updateFavouriteMusic(data: Any)

}