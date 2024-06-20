package com.bangkit.rextra

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bangkit.rextra.data.viewmodel.EditProfileViewModel
import com.bangkit.rextra.databinding.ActivityEditProfileBinding
import com.bumptech.glide.Glide
import com.github.dhaval2404.imagepicker.ImagePicker
import java.io.File

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private val viewModel: EditProfileViewModel by viewModels()
    private var selectedImageFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getUserProfile()
        observeViewModel()

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val username = binding.etUsername.text.toString()
            viewModel.updateUserProfile(name, email, username)
        }

        binding.btnUbahFoto.setOnClickListener {
            ImagePicker.with(this)
                .cropSquare()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start { resultCode, data ->
                    when (resultCode) {
                        Activity.RESULT_OK -> {
                            val fileUri = data?.data
                            selectedImageFile = File(fileUri?.path ?: "")
                            binding.ivProfileImage.setImageURI(fileUri)
                        }
                        ImagePicker.RESULT_ERROR -> {
                            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val username = binding.etUsername.text.toString()
            viewModel.updateUserProfile(name, email, username)
            selectedImageFile?.let { viewModel.updateProfileImage(it) }
        }
    }

    private fun observeViewModel() {
        viewModel.userProfile.observe(this, Observer { userProfile ->
            binding.etName.setText(userProfile.name)
            binding.etEmail.setText(userProfile.email)
            binding.etUsername.setText(userProfile.username)
            Glide.with(this).load(userProfile.profileUrl).into(binding.ivProfileImage)
        })

        viewModel.updateResult.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }
}
