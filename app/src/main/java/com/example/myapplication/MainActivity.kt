package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.ui.auth.fragment.AuthFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(AuthFragment())
    }

    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_fragment_container, fragment, fragment.toString())
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val fragmentCount = supportFragmentManager.backStackEntryCount
        if (fragmentCount > 1) {
            super.onBackPressed()
        } else {
            finish()
        }
    }
}