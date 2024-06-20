package com.bangkit.rextra.data.response.recommendation

import com.google.gson.annotations.SerializedName

data class RecommendResult(
    @SerializedName("data")
    val data: List<RecommendDataResponse>
)
