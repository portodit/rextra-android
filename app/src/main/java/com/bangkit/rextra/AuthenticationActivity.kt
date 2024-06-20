package com.bangkit.rextra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if (savedInstanceState == null) {
            val fragment = when (intent.getStringExtra("fragment")) {
                "register" -> RegisterFragment()
                else -> LoginFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.auth_container,
                fragment
            ).commit()
        }
    }
}