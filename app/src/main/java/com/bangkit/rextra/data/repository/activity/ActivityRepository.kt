package com.bangkit.rextra.data.repository.activity

import com.bangkit.rextra.data.remote.APIConfig
import com.bangkit.rextra.data.response.activity.ActivitiesResponse
import com.bangkit.rextra.data.response.activity.ActivityDetailResponse

class ActivityRepository {
    private val apiService = APIConfig.getActivityApiService()
    companion object {
        const val tempToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEyLCJpYXQiOjE3MTg5MDQ4NzAsImV4cCI6MTcxODkwODQ3MH0.dFEzfSRinN6AeLcqCjChuVjMTunwNnJLdprTF2O6_ws"
    }

    suspend fun fetchActivities(token: String): ActivitiesResponse {
        return apiService.fetchAllActivities("Bearer $tempToken")
    }

    suspend fun fetchDetailKegiatan(token: String, id: String): ActivityDetailResponse {
        return apiService.fetchDetailActivity("Bearer $tempToken", id)
    }
}