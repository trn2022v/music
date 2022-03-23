package com.example.myapplication.data.local.auth

interface LocalAuthServiceI {
    fun onLoginClicked(email: String, password: String): String?
    fun updateUserData(data: Any)
}
