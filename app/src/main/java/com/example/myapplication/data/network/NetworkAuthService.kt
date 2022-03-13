package com.example.myapplication.data.network

interface NetworkAuthService {
    fun onLoginClicked(email: String, password: String): String?
    fun updateUserData(data: Any)
}
