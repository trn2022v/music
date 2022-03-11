package com.example.myapplication.ui.auth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.ui.auth.AuthViewModel
import com.example.myapplication.ui.music.fragment.MusicFragment
import com.example.myapplication.ui.reg.fragment.RegFragment
import com.google.android.material.textfield.TextInputLayout

class AuthFragment : Fragment() {

    private lateinit var progress: ProgressBar
    private lateinit var overlay: FrameLayout
    private lateinit var viewModel: AuthViewModel
    private lateinit var buttonLogin: AppCompatButton
    private lateinit var buttonReg: AppCompatButton
    private lateinit var loginField: TextInputLayout
    private lateinit var passwordField: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.log_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]

        buttonLogin = view.findViewById(R.id.button_login)
        buttonReg = view.findViewById(R.id.button_reg)
        loginField = view.findViewById(R.id.input_layout_login)
        passwordField = view.findViewById(R.id.input_layout_password)
        overlay = view.findViewById(R.id.overlay_container)
        progress = view.findViewById(R.id.progress)

        loginField.editText?.addTextChangedListener {
            viewModel.emailLifeData.value = it.toString()
        }

        passwordField.editText?.addTextChangedListener {
            viewModel.passwordLifeData.value = it.toString()
        }

        buttonLogin.setOnClickListener {
            val emailText = loginField.editText?.text.toString()
            val passwordText = passwordField.editText?.text.toString()
            viewModel.onLoginClicked(emailText, passwordText)
        }
        buttonReg.setOnClickListener {
            (activity as MainActivity).openFragment(
                RegFragment(),
                doClearBackStack = true,
                tag = "RegFragment"
            )
        }

        subscribeOnLiveData()
        restoreValues()
    }

    private fun restoreValues() {
        loginField.editText?.setText(viewModel.emailLifeData.value ?: "")
        passwordField.editText?.setText(viewModel.passwordLifeData.value ?: "")
    }


    private fun subscribeOnLiveData() {
        viewModel.isLoginSuccessLiveData.observe(viewLifecycleOwner) {
            (activity as MainActivity).openFragment(
                MusicFragment(),
                doClearBackStack = true,
                tag = "MusicFragment"
            )
        }

        viewModel.isLoginFailedLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Неправильный Логин или Пароль", Toast.LENGTH_SHORT).show()
        }

        viewModel.showProgressLiveData.observe(viewLifecycleOwner) {
            showProgress()
        }

        viewModel.hideProgressLiveData.observe(viewLifecycleOwner) {
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