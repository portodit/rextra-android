package com.bangkit.rextra.data.response.activity

import com.google.gson.annotations.SerializedName

data class ActivityDetailResponse(
    @SerializedName("data")
    val data: ActivityDetailDataResponse
)
