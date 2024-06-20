package com.bangkit.rextra.data.remote

import com.bangkit.rextra.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIConfig {
    companion object{
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client =
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        fun getAPIService() : APIService {
            return retrofit.create(APIService::class.java)
        }
        fun getActivityApiService(): ActivityApiService {
            return retrofit.create(ActivityApiService::class.java)
        }
        fun getRecommendApiService(): RecommendApiService {
            return retrofit.create(RecommendApiService::class.java)
        }
        fun getUserApiService(): UserApiService {
            return retrofit.create(UserApiService::class.java)
        }
    }
}