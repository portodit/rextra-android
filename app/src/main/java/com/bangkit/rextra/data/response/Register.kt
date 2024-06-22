package com.bangkit.rextra.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Register(

	@field:SerializedName("success")
	val success: Boolean?,

	@field:SerializedName("statusCode")
	val statusCode: Int?,

	@field:SerializedName("message")
	val message: String?,

	) : Parcelable