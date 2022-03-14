package com.example.myapplication.ui.music.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.ui.auth.AuthViewModel
import com.example.myapplication.ui.auth.fragment.AuthFragment
import com.example.myapplication.ui.music.MusicViewModel

class MusicFragment : Fragment() {

    private lateinit var viewModel: MusicViewModel
    private lateinit var logOut: AppCompatButton


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.music_layout, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logOut = view.findViewById(R.id.button_log_out)
        viewModel = ViewModelProvider(this)[MusicViewModel::class.java]

        subscribeToLiveData()
        setListener()
    }

    private fun subscribeToLiveData() {

        viewModel.logoutLiveData.observe(viewLifecycleOwner) {
            (activity as MainActivity).openFragment(
                AuthFragment(),
                doClearBackStack = true,
                "AuthFragment"
            )
        }
    }

    private fun setListener() {
        logOut.setOnClickListener {
            viewModel.logout()
        }
    }
}