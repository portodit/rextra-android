package com.bangkit.rextra.ui.profil

import android.os.Bundle
import android.text.Editable
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangkit.rextra.R
import com.bangkit.rextra.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private val viewModel: EditProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        viewModel.fetchUser()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSave.setOnClickListener {
            with(binding) {
                val email = profileEmail.text.toString()
                val username = profileUserName.text.toString()
                val name = profilName.text.toString()
                
                viewModel.updateUserData(username = username, name = name, email = email)
                finish()
            }
        }

        viewModel.userData.observe(this) {
            with(binding) {
                profilName.setText(it.name)
                profileEmail.setText(it.email)
                profileUserName.setText(it.userName)
            }
        }

    }
}