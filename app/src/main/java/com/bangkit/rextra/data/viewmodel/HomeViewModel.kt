package com.bangkit.rextra.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.rextra.data.repository.activity.ActivityRepository
import com.bangkit.rextra.data.repository.user.UserRepository
import com.bangkit.rextra.data.response.activity.ActivityDataResponse
import com.bangkit.rextra.data.response.user.UserDataResponse
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val activityRepository = ActivityRepository()
    private val userRepository =  UserRepository()

    private val _activies = MutableLiveData<List<ActivityDataResponse>>()
    val activies = _activies

    private val _userData = MutableLiveData<UserDataResponse>()
    val userData = _userData

    fun fetchActivities() {
        viewModelScope.launch {
            val response = activityRepository.fetchActivities("")
            _activies.value = response.data
        }
    }

    fun fetchUser() {
        viewModelScope.launch {
            val response = userRepository.fetchUser("")
            _userData.value = response.data
        }
    }
}