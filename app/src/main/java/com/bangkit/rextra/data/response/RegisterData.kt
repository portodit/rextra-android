package com.bangkit.rextra.data.response

data class RegisterData(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)

