package com.bangkit.rextra.data.response

data class UserProfileResponse(
    val success: Boolean,
    val statusCode: Int,
    val message: String,
    val data: UserProfile
)