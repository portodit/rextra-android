package com.bangkit.rextra.data.repository.recommend

import com.bangkit.rextra.data.remote.APIConfig
import com.bangkit.rextra.data.repository.activity.ActivityRepository.Companion.tempToken
import com.bangkit.rextra.data.response.recommendation.RecommendResult

class RecomRepository {
    private val apiService = APIConfig.getRecommendApiService()

    suspend fun getRecommendations(
        token: String,
        penyelenggara: String,
        preference: String,
        userPreference: String,
        skills: String,
        durasi: String,
        pastActivities: String
    ): RecommendResult {
        return apiService.getRecommendation(
            token = "Bearer $tempToken",
            penyelenggara,
            preference,
            userPreference,
            skills,
            durasi,
            pastActivities
        )
    }
}