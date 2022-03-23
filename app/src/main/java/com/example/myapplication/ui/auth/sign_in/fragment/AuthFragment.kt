package com.example.myapplication.ui.auth.sign_in.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.AppNavigation
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.data.storage.preferances.AppPreferencesImpl
import com.example.myapplication.ui.auth.base.BaseAuthFragment
import com.example.myapplication.ui.auth.sign_in.AuthViewModel
import com.example.myapplication.ui.music.fragment.MusicFragment
import com.example.myapplication.ui.auth.sign_up.fragment.RegFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

 @AndroidEntryPoint
class AuthFragment : BaseAuthFragment() {

    @Inject
    lateinit var appNavigation: AppNavigation

    private var binding: LayoutSignInBinding? = null

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LayoutSignInBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (binding?.inputLayoutLogin?.editText?.text?.isBlank() == true) {
            ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color_default)?.let {
                binding?.inputLayoutLogin?.setBoxStrokeColorStateList(it)
            }
        } else {
            ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color)?.let { colorList ->
                binding?.inputLayoutLogin?.setBoxStrokeColorStateList(colorList)
            }
        }

        initListeners()
        subscribeOnLiveData()
    }

    private fun initListeners() {
        binding?.inputLayoutLogin?.editText?.addTextChangedListener {
            it?.let {
                if (it.isBlank()) {
                    ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color_default)?.let { colorList ->
                        binding?.inputLayoutLogin?.setBoxStrokeColorStateList(colorList)
                    }
                } else {
                    ContextCompat.getColorStateList(requireContext(), R.color.auth_input_layout_stroke_color)?.let { colorList ->
                        binding?.inputLayoutLogin?.setBoxStrokeColorStateList(colorList)
                    }
                }
            }
        }
        binding?.buttonSignIn?.setOnClickListener {
            val email = binding?.inputLayoutLogin?.editText?.text.toString()
            val password = binding?.inputLayoutPassword?.editText?.text.toString()
            viewModel.onSignInClicked(email, password)
        }
        binding?.buttonSignUp?.setOnClickListener {
            this.findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    private fun subscribeOnLiveData() {
        viewModel.showCredentialsErrorLiveData.observe(this) {
            binding?.inputLayoutLogin?.error =
                getString(R.string.auth_sign_in_credentials_incorrect)
            binding?.inputLayoutPassword?.error =
                getString(R.string.auth_sign_in_credentials_incorrect)
        }
        viewModel.signInSuccessLiveData.observe(viewLifecycleOwner) {
            //      TODO: pass test params. Do nothing.
            val direction =
                SignInFragmentDirections.actionSignInFragmentToContentNavGraph(
                    UserEntity(
                        id = 7,
                        login = "Yurez",
                        "zzz"
                    )
                )
            this.findNavController().navigate(direction)
        }
        viewModel.showProgressLiveData.observe(viewLifecycleOwner) {
            binding?.progress?.isVisible = true
        }
        viewModel.hideProgressLiveData.observe(viewLifecycleOwner) {
            binding?.progress?.isVisible = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}