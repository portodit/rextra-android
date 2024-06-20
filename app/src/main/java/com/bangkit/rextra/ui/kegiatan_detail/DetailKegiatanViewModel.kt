package com.bangkit.rextra.ui.kegiatan_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.rextra.data.repository.activity.ActivityRepository
import com.bangkit.rextra.data.response.activity.ActivityDetailDataResponse
import kotlinx.coroutines.launch

class DetailKegiatanViewModel: ViewModel() {
    private val activityRepository = ActivityRepository()

    private val _activity = MutableLiveData<ActivityDetailDataResponse>()
    val activity = _activity


    fun fetchDetailActivity(id: String) {
        viewModelScope.launch {
            val response = activityRepository.fetchDetailKegiatan("", id = id)
            _activity.value = response.data
        }
    }
}