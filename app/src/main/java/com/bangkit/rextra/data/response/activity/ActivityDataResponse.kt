package com.bangkit.rextra.data.response.activity

import com.google.gson.annotations.SerializedName

data class ActivityDataResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("kategori")
    val jenisKegiatan: String,
    @SerializedName("posisi")
    val namaKegiatan: String
)
