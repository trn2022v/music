package com.example.myapplication

import androidx.fragment.app.Fragment

interface AppNavigation {
    fun openFragment(fragment: Fragment, doClearBackStack: Boolean = false, tag: String? = null)
}