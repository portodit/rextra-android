package com.bangkit.rextra.data.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecommendRequest(
    val ptn: String,
    val kegiatan: String,
    val lokasi: String,
    val deskripsi: String,
    val kegiatanPernah: String
): Parcelable {
    companion object {
        fun empty() = RecommendRequest(
            ptn = "",
            kegiatan = "",
            lokasi = "",
            deskripsi = "",
            kegiatanPernah = ""
        )
    }
}
