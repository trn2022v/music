package com.example.myapplication.ui.auth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.data.storage.preferances.AppPreferencesImpl
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
    private lateinit var saveCredentialsCheckBox: AppCompatCheckBox

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.log_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin = view.findViewById(R.id.button_login)
        buttonReg = view.findViewById(R.id.button_reg)
        loginField = view.findViewById(R.id.input_login)
        passwordField = view.findViewById(R.id.input_password)
        overlay = view.findViewById(R.id.overlay_container)
        progress = view.findViewById(R.id.progress)
        saveCredentialsCheckBox = view.findViewById(R.id.save_credentials_check_box)


        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        viewModel.setSharedPreferences(AppPreferencesImpl.getInstance(requireContext()))
        viewModel.fetchStoredData()

        restoreValues()
        initListeners()
        subscribeOnLiveData()
    }

    private fun initListeners() {
        loginField.editText?.addTextChangedListener {
            viewModel.setUpdatedEmail(it.toString())
        }

        passwordField.editText?.addTextChangedListener {
            viewModel.setUpdatedPassword(it.toString())
        }

        buttonLogin.setOnClickListener {
            val emailText = loginField.editText?.text.toString()
            val passwordText = passwordField.editText?.text.toString()
            viewModel.onLoginClicked(emailText, passwordText)
        }
        buttonReg.setOnClickListener {
            (activity as MainActivity).openFragment(
                RegFragment(),
                doClearBackStack = false,
                tag = "RegFragment"
            )
        }
        saveCredentialsCheckBox.setOnCheckedChangeListener { _, isSelected ->
            viewModel.setSaveCredentialIsSelected(
                isSelected
            )
        }
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
            Toast.makeText(context, R.string.incorrect_login, Toast.LENGTH_SHORT).show()
        }

        viewModel.showProgressLiveData.observe(viewLifecycleOwner) {
            showProgress()
        }

        viewModel.hideProgressLiveData.observe(viewLifecycleOwner) {
            hideProgress()
        }
        viewModel.saveCredentialCheckedLifeData.observe(
            viewLifecycleOwner
        ) { isSelected -> saveCredentialsCheckBox.isChecked = isSelected }

        viewModel.emailLifeData.observe(
            viewLifecycleOwner
        ) { email ->
            loginField.editText?.setText(email)
            loginField.editText?.setSelection(email.length)
        }

        viewModel.passwordLifeData.observe(
            viewLifecycleOwner
        ) { password ->
            passwordField.editText?.setText(password)
            passwordField.editText?.setSelection(password.length)
        }

    }

    private fun showProgress() {
        progress.isVisible = true
        overlay.isVisible = true
    }

    private fun hideProgress() {
        progress.isVisible = false
        overlay.isVisible = false
    }
}