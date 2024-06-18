package com.bangkit.rextra.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.rextra.data.repository.MainRepository
import com.bangkit.rextra.data.response.Login
import com.bangkit.rextra.data.response.LoginData
import com.bangkit.rextra.data.response.RegisterData

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val message: LiveData<String> = mainRepository.message

    val isLoading: LiveData<Boolean> = mainRepository.isLoading

    val isError: LiveData<Boolean> = mainRepository.isError

    val isSuccess: LiveData<Boolean> = mainRepository.isSuccess

    val userlogin: LiveData<Login> = mainRepository.userlogin

    fun login(loginData: LoginData) {
        mainRepository.getResponseLogin(loginData)
    }

    fun register(registDataUser: RegisterData) {
        mainRepository.getResponseRegister(registDataUser)
    }
}