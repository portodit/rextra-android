package com.bangkit.rextra.data.remote

import com.bangkit.rextra.data.response.recommendation.RecommendResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface RecommendApiService {
    @FormUrlEncoded
    @POST("recommendations")
    suspend fun getRecommendation(
        @Header("Authorization") token: String,
        @Field("penyelenggara") penyelenggara: String,
        @Field("preference") preference: String,
        @Field("user_preference") userPreference: String,
        @Field("skills") skills: String,
        @Field("durasi") durasi: String,
        @Field("past_activities") pastActivities: String
    ): RecommendResult
}