package com.example.myapplication.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.ui.profile.ProfileViewModel

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var logOutBtn: AppCompatButton
    private lateinit var returnBtn: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        logOutBtn = view.findViewById(R.id.button_log_out)
        returnBtn = view.findViewById(R.id.return_button)
        lifecycle.addObserver(viewModel)
        subscribeToLiveData()
        setListener()
    }

    private fun setListener() {
        logOutBtn.setOnClickListener {
            viewModel.logout()
        }
        returnBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_profileFragment_to_musicFragment)
        }


    }
    private fun subscribeToLiveData() {
        viewModel.logoutLiveData.observe(viewLifecycleOwner) {
            this.findNavController().navigate(R.id.action_profileFragment_to_authFragment)
        }
    }
}
