package com.example.myapplication.ui.auth.activity

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ui.reg.RegActivity
import com.google.android.material.textfield.TextInputLayout


class AuthActivity : AppCompatActivity() {
    private lateinit var progress: ProgressBar
    private lateinit var overlay: FrameLayout
    private lateinit var viewModel: AuthViewModel
    private lateinit var buttonLogin: AppCompatButton
    private lateinit var buttonReg: AppCompatButton
    private lateinit var loginField: TextInputLayout
    private lateinit var passwordField: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_layout)

        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]



        buttonLogin = findViewById(R.id.button_login)
        buttonReg = findViewById(R.id.button_reg)
        loginField = findViewById(R.id.input_layout_login)
        passwordField = findViewById(R.id.input_layout_password)
        overlay = findViewById(R.id.overlay_container)
        progress = findViewById(R.id.progress)


        buttonLogin.setOnClickListener {
            val emailText = loginField.editText?.text.toString()
            val passwordText = passwordField.editText?.text.toString()
            viewModel.onLoginClicked(emailText, passwordText)
        }
        subscribeOnLiveData()
    }

    private fun subscribeOnLiveData() {
        viewModel.isLoginSuccessLiveData.observe(this) {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
        viewModel.isLoginFailedLiveData.observe(this) {
            Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_SHORT).show()
        }
        viewModel.showProgressLiveData.observe(this) {
            showProgress()
        }
        viewModel.hideProgressLiveData.observe(this) {
            hideProgress()
        }
    }

    private fun hideProgress() {
        progress.isVisible = false
        overlay.isVisible = false
    }

    private fun showProgress() {
        progress.isVisible = true
        overlay.isVisible = true
    }
}