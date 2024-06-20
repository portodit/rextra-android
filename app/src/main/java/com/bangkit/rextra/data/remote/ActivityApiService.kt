package com.bangkit.rextra.data.remote

import com.bangkit.rextra.data.response.activity.ActivitiesResponse
import com.bangkit.rextra.data.response.activity.ActivityDetailResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ActivityApiService {
    @GET("activities")
    suspend fun fetchAllActivities(
        @Header("Authorization") token: String,
    ): ActivitiesResponse

    @GET("activities/{activityId}")
    suspend fun fetchDetailActivity(
        @Header("Authorization") token: String,
        @Path("activityId") activityId: String
    ): ActivityDetailResponse
}