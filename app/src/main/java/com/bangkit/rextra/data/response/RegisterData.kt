package com.bangkit.rextra.data.response

data class RegisterData(
    var name: String,
    var email: String,
    var password: String,
    var confirmPassword: String
)