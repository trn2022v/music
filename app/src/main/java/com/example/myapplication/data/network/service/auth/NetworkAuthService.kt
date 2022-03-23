package com.example.myapplication.data.network.service.auth

interface NetworkAuthService {
    fun onLoginClicked(email: String, password: String): String?
    fun updateUserData(data: Any)
}
