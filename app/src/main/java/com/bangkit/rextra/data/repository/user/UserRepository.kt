package com.bangkit.rextra.data.repository.user

import com.bangkit.rextra.data.remote.APIConfig
import com.bangkit.rextra.data.repository.activity.ActivityRepository.Companion.tempToken
import com.bangkit.rextra.data.request.UpdateUserRequest

class UserRepository {
    private val apiService = APIConfig.getUserApiService()

    suspend fun fetchUser(token: String) = apiService.fetchUser("Berar $tempToken")

    suspend fun updateUserData(token: String, name: String, username: String, email: String) {
        val userRequest = UpdateUserRequest(
            name = name, email = email, username = username
        )
        apiService.updateProfile(token = "Bearer $tempToken", userRequest)
    }
}