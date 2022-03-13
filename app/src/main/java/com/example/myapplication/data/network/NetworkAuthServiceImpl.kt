package com.example.myapplication.data.network

class NetworkAuthServiceImpl : NetworkAuthService {
    override fun onLoginClicked(email: String, password: String): String? {
        val isEmailValid =
            email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val passwordValid = password.isNotBlank() && password.length > 5

        return if (isEmailValid && passwordValid) {
            onLogin(email, password)
        } else {
            null
        }
    }

    override fun updateUserData(data: Any) {
        TODO("Not yet implemented")
    }


    private fun onLogin(email: String, password: String): String {
        return "token"

    }
}