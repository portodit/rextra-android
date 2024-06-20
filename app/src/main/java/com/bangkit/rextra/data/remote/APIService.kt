package com.bangkit.rextra.data.remote

import com.bangkit.rextra.data.response.Login
import com.bangkit.rextra.data.response.LoginData
import com.bangkit.rextra.data.response.Register
import com.bangkit.rextra.data.response.RegisterData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface APIService {
    @POST("auth/login")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Login>

    @POST("auth/register")
    fun registUser(@Body requestRegister: RegisterData): Call<Register>


    @POST("auth/login")
    fun loginUser(@Body requestLogin: LoginData): Call<Login>
}
