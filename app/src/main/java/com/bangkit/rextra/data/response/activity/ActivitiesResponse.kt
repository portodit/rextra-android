package com.bangkit.rextra.data.response.activity

import com.google.gson.annotations.SerializedName

data class ActivitiesResponse(
    @SerializedName("statusCode")
    val code: String,
    @SerializedName("data")
    val data: List<ActivityDataResponse>
)
