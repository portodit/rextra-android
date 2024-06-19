package com.bangkit.rextra.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Register(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String

) : Parcelable
