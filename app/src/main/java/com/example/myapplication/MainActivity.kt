package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (savedInstanceState == null) {
//
//            if (AppPreferencesImpl.getInstance(this).getToken().isBlank()) {
//                openFragment(AuthFragment(), tag = "AuthFragment")
//
//            } else {
//                openFragment(MusicFragment(), tag = "MusicFragment")
//            }
//        }
    }

    fun openFragment(fragment: Fragment, doClearBackStack: Boolean = false, tag: String? = null) {
        Handler(Looper.myLooper()!!).postDelayed({
            if (doClearBackStack) {
                clearBackStack()
            }
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out
                )
                .replace(R.id.main_fragment_container, fragment, tag)
                .addToBackStack(null)
                .commit()
        }, 300)

    }

    override fun onBackPressed() {
        val fragmentCount = supportFragmentManager.backStackEntryCount
        if (fragmentCount > 1) {
            super.onBackPressed()
        } else {
            finish()
        }
    }

//    fun findFragmentByTag(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun clearBackStack() =
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

//class MyCustomThread : HandlerThread("MyCustomThread") {
//    private var myHandler: Handler? = null
//    override fun run() {
//        super.run()
//        val looper = Looper.myLooper()
//        looper?.let {
//            myHandler = Handler(it)
//        }
//    }
//
//}