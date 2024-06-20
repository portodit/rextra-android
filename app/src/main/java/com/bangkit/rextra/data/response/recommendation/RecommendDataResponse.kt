package com.bangkit.rextra.data.response.recommendation

import com.google.gson.annotations.SerializedName

data class RecommendDataResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("deskripsi")
    val deskripsi: String,
    @SerializedName("penyelenggara")
    val penyelenggara: String,
    @SerializedName("posisi")
    val posisi: String
)