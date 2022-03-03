package com.example.myapplication

class AuthModel {
    fun onLoginClicked(email: String, password: String): Boolean {
        val isEmailValid = email.isNotBlank()
        val passwordValid = password.isNotBlank()

        return isEmailValid && passwordValid
    }
}