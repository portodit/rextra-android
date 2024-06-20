package com.bangkit.rextra.data.remote

import com.bangkit.rextra.data.response.Login
import com.bangkit.rextra.data.response.LoginData
import com.bangkit.rextra.data.response.Register
import com.bangkit.rextra.data.response.RegisterData
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import com.bangkit.rextra.data.response.UserProfileResponse
import com.bangkit.rextra.data.response.UpdateUserResponse

import retrofit2.http.*

interface APIService {
    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Login>

    @POST("register")
    fun registUser(@Body requestRegister: RegisterData): Call<Register>

    @POST("login")
    fun loginUser(@Body requestLogin: LoginData): Call<Login>

    @GET("users")
    fun getUserProfile(): Call<UserProfileResponse>

    @PUT("users")
    fun updateUserProfile(
        @Body userProfile: Map<String, String>
    ): Call<UpdateUserResponse>

    @Multipart
    @PUT("users/profile-image")
    fun updateProfileImage(
        @Part profileImage: MultipartBody.Part
    ): Call<UserProfileResponse>
}

