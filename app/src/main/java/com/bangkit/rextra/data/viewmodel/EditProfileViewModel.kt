package com.bangkit.rextra.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.rextra.data.remote.APIConfig
import com.bangkit.rextra.data.response.UserProfile
import com.bangkit.rextra.data.response.UserProfileResponse
import com.bangkit.rextra.data.response.UpdateUserResponse
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class EditProfileViewModel : ViewModel() {
    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile> = _userProfile

    private val _updateResult = MutableLiveData<String>()
    val updateResult: LiveData<String> = _updateResult

    fun getUserProfile() {
        val service = APIConfig.getAPIService()
        service.getUserProfile().enqueue(object : Callback<UserProfileResponse> {
            override fun onResponse(call: Call<UserProfileResponse>, response: Response<UserProfileResponse>) {
                if (response.isSuccessful) {
                    _userProfile.postValue(response.body()?.data)
                }
            }

            override fun onFailure(call: Call<UserProfileResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }

    fun updateUserProfile(name: String, email: String, username: String) {
        val service = APIConfig.getAPIService()
        val userProfileMap = mapOf("name" to name, "email" to email, "username" to username)
        service.updateUserProfile(userProfileMap).enqueue(object : Callback<UpdateUserResponse> {
            override fun onResponse(call: Call<UpdateUserResponse>, response: Response<UpdateUserResponse>) {
                if (response.isSuccessful) {
                    _updateResult.postValue(response.body()?.message)
                }
            }

            override fun onFailure(call: Call<UpdateUserResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }

    fun updateProfileImage(imageFile: File) {
        val requestBody = RequestBody.create(MediaType.parse("image/*"), imageFile)
        val multipartBody = MultipartBody.Part.createFormData("profileImage", imageFile.name, requestBody)

        val service = APIConfig.getAPIService()
        service.updateProfileImage(multipartBody).enqueue(object : Callback<UserProfileResponse> {
            override fun onResponse(call: Call<UserProfileResponse>, response: Response<UserProfileResponse>) {
                if (response.isSuccessful) {
                    _userProfile.postValue(response.body()?.data)
                }
            }

            override fun onFailure(call: Call<UserProfileResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
