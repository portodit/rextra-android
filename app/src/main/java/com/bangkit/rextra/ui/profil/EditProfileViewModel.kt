package com.bangkit.rextra.ui.profil

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.rextra.data.repository.user.UserRepository
import com.bangkit.rextra.data.response.user.UserDataResponse
import kotlinx.coroutines.launch

class EditProfileViewModel: ViewModel() {
    private val userRepository = UserRepository()

    private val _userData = MutableLiveData<UserDataResponse>()
    val userData = _userData

    fun fetchUser() {
        viewModelScope.launch {
            val response = userRepository.fetchUser("")
            _userData.value = response.data
        }
    }

    fun updateUserData(username: String, name: String, email: String) {
        viewModelScope.launch {
            userRepository.updateUserData(
                token = "",
                name = name,
                username = username,
                email = email
            )
        }
    }
}