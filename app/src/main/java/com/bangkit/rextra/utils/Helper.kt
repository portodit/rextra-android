package com.bangkit.rextra.utils

import android.text.TextUtils
import android.util.Patterns

object Helper {

    fun isValidEmail(email: String): Boolean =
        !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun validateMinLength(password: String): Boolean =
        !TextUtils.isEmpty(password) && password.length >= Constants.MIN_LENGTH_PASSWORD


}
