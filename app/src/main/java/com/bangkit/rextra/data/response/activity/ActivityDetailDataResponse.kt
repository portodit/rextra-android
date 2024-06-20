package com.bangkit.rextra.data.response.activity

import com.google.gson.annotations.SerializedName

data class ActivityDetailDataResponse(
    @SerializedName("kategori")
    val jenisKegiatan: String,
    @SerializedName("subKategori")
    val namaKegiatan: String,
    @SerializedName("lokasi")
    val lokasiKegiatan: String,
    @SerializedName("durasi")
    val durasiKegiatan: String,
    @SerializedName("penyelenggara")
    val penyelenggara: String,

    @SerializedName("tanggalPendaftaran")
    val tanggalDaftar: String,
    @SerializedName("deskripsi")
    val deskripsiKegiatan: String,
    @SerializedName("persyaratan")
    val syaratPendaftaran: List<String>,
    @SerializedName("skill")
    val requirementSkill: List<String>,
)
