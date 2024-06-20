package com.bangkit.rextra.data.remote

import com.bangkit.rextra.data.request.UpdateUserRequest
import com.bangkit.rextra.data.response.user.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserApiService {
    @GET("users")
    suspend fun fetchUser(
        @Header("Authorization") token: String
    ): UserResponse

    @PUT("users")
    suspend fun updateProfile(
        @Header("Authorization") token: String,
        @Body user: UpdateUserRequest
    )
}