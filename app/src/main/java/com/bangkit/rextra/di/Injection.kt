package com.bangkit.rextra.di

import android.content.Context
import com.bangkit.rextra.data.remote.APIConfig
import com.bangkit.rextra.data.repository.MainRepository

object Injection {
    fun provideRepository(context: Context): MainRepository {
        val apiService = APIConfig.getAPIService()
        return MainRepository(apiService)
    }
}