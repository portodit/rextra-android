package com.bangkit.rextra.ui.gercep

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.rextra.data.repository.recommend.RecomRepository
import com.bangkit.rextra.data.request.RecommendRequest
import com.bangkit.rextra.data.response.recommendation.RecommendDataResponse
import kotlinx.coroutines.launch

class HasilRekomendasiViewModel: ViewModel() {
    private val repository = RecomRepository()

    private val _results = MutableLiveData<List<RecommendDataResponse>>()
    val results = _results

    fun fetchResult(q: RecommendRequest) {
        viewModelScope.launch {
            val response = repository.getRecommendations("",
                penyelenggara = q.ptn,
                preference = q.lokasi,
                userPreference = q.kegiatan,
                skills = q.deskripsi,
                durasi = "1 Tahun",
                pastActivities = q.kegiatanPernah
            )
            _results.value = response.data
        }
    }
}