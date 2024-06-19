package com.bangkit.rextra

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

class MyApplication : Application() {
    companion object {
        private const val DATASTORE_NAME = "settings"
        val Context.dataStore by preferencesDataStore(name = DATASTORE_NAME)
    }

    override fun onCreate() {
        super.onCreate()
        // Inisialisasi lain yang diperlukan
    }
}
