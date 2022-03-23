package com.example.myapplication.ui.auth.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.storage.preferances.AppPreferences
import com.omisoft.myapplication.R
import com.omisoft.myapplication.data.preferences.PreferencesI
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseAuthFragment : Fragment() {
    @Inject
    lateinit var preferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (preferences.getUserToken().isNotBlank()) {
            findNavController().navigate(R.id.navi)
        }
    }
}