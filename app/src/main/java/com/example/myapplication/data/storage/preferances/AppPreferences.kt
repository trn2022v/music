package com.example.myapplication.data.storage.preferances

interface AppPreferences {
    fun  isSaveCredentialSelected(): Boolean
    fun  setSaveCredentialIsSelected(isSelected : Boolean)

    fun saveLogin(login: String)
    fun savePassword(password: String)

    fun getLogin(): String
    fun getPassword(): String

    fun saveToken(token: String)
    fun getToken(): String

}