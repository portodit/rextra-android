package com.bangkit.rextra.ui.profil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.rextra.data.repository.user.UserRepository
import com.bangkit.rextra.data.response.user.UserDataResponse
import kotlinx.coroutines.launch

class ProfilViewModel : ViewModel() {
    private val userRepository = UserRepository()

    private val _userData = MutableLiveData<UserDataResponse>()
    val userData = _userData

    fun fetchUser() {
        viewModelScope.launch {
            val response = userRepository.fetchUser("")
            _userData.value = response.data
        }
    }
}