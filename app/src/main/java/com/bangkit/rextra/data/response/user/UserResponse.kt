package com.bangkit.rextra.data.response.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val data: UserDataResponse
)
