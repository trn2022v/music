package com.example.myapplication.ui.reg.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.ui.auth.AuthViewModel
import com.example.myapplication.ui.reg.RegViewModel
import com.google.android.material.textfield.TextInputLayout

class RegFragment : Fragment() {
    private lateinit var progress: ProgressBar
    private lateinit var overlay: FrameLayout
    private lateinit var viewModel: RegViewModel
    private lateinit var buttonReg: AppCompatButton
    private lateinit var emailField: TextInputLayout
    private lateinit var passwordField: TextInputLayout
    private lateinit var passwordField2: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reg_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonReg = view.findViewById(R.id.button_reg)
        emailField = view.findViewById(R.id.input_login)
        passwordField = view.findViewById(R.id.input_password)
        passwordField2 = view.findViewById(R.id.input_password2)
        overlay = view.findViewById(R.id.overlay_container)
        progress = view.findViewById(R.id.progress)

        viewModel = ViewModelProvider(this)[RegViewModel::class.java]



        emailField.editText?.addTextChangedListener {
            viewModel.emailLifeData.value = it.toString().trim()
        }

        passwordField.editText?.addTextChangedListener {
            viewModel.passwordLifeData.value = it.toString().trim()
        }
        passwordField2.editText?.addTextChangedListener {
            viewModel.passwordLifeData.value = it.toString().trim()
        }
        buttonReg.setOnClickListener {
            (activity as MainActivity).openFragment(
                RegFragment(),
                doClearBackStack = false,
                tag = "RegFragment"
            )
        }

    }
//        restoreValues()
}


//    private fun restoreValues() {
//        emailField.editText?.setText(viewModel.emailLifeData.value ?: "")
//        passwordField.editText?.setText(viewModel.passwordLifeData.value ?: "")
//        passwordField2.editText?.setText(viewModel.passwordLifeData.value ?: "")
//    }

