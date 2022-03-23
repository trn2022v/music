package com.example.myapplication.data.storage.preferances

interface AppPreferences {
    fun saveEmail(email: String)
    fun savePassword(password: String)

    fun getEmail(): String
    fun getPassword(): String

    fun saveUserToken(token: Int?)
    fun getUserToken(): String

}