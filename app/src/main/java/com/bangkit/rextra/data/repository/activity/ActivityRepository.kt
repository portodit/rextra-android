package com.bangkit.rextra.data.repository.activity

import com.bangkit.rextra.data.remote.APIConfig
import com.bangkit.rextra.data.response.activity.ActivitiesResponse
import com.bangkit.rextra.data.response.activity.ActivityDetailResponse

class ActivityRepository {
    private val apiService = APIConfig.getActivityApiService()
    companion object {
        const val tempToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjExLCJpYXQiOjE3MTg5NjE3MTF9.JrEkdWn6fvKIEwTXPUq82X2Hn54s2BECGZ5MmSmAoI4"
    }

    suspend fun fetchActivities(token: String): ActivitiesResponse {
        return apiService.fetchAllActivities("Bearer $tempToken")
    }

    suspend fun fetchDetailKegiatan(token: String, id: String): ActivityDetailResponse {
        return apiService.fetchDetailActivity("Bearer $tempToken", id)
    }
}