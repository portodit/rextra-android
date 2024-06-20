package com.bangkit.rextra.data.response

data class UserProfile(
    val id: Int,
    val name: String,
    val username: String?,
    val email: String,
    val profileUrl: String?,
    val createdAt: String,
    val updatedAt: String
)