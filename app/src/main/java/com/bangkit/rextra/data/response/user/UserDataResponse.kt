package com.bangkit.rextra.data.response.user

import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val userName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("profileUrl")
    val profileUrl: String
)
