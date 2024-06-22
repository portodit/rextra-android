package com.bangkit.rextra.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bangkit.rextra.data.remote.APIService
import com.bangkit.rextra.data.response.Login
import com.bangkit.rextra.data.response.LoginData
import com.bangkit.rextra.data.remote.APIConfig
import com.bangkit.rextra.data.response.Register
import com.bangkit.rextra.data.response.RegisterData
import com.bangkit.rextra.utils.wrapEspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(
    private val apiService: APIService
) {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> = _isError

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean> = _isSuccess

    private val _userLogin = MutableLiveData<Login>()
    var userlogin: LiveData<Login> = _userLogin

    fun getResponseLogin(loginData: LoginData) {
        wrapEspressoIdlingResource {
            _isLoading.value = true
            val api = APIConfig.getAPIService().loginUser(loginData)
            api.enqueue(object : Callback<Login> {
                override fun onResponse(
                    call: Call<Login>,
                    response: Response<Login>
                ) {
                    _isLoading.value = false
                    val responseBody = response.body()

                    if (response.isSuccessful) {
                        _userLogin.value = responseBody!!
                        _isSuccess.value = true
                    } else {
                        when (response.code()) {
                            401 -> _message.value = "Email atau password salah"
                            408 -> _message.value = "Koneksi internet buruk"
                            else -> _message.value = "Error: " + response.message()
                        }
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    _isLoading.value = false
                    _message.value = "Error: " + t.message.toString()
                }

            })
        }
    }

    fun getResponseRegister(registDataUser: RegisterData) {
        wrapEspressoIdlingResource {
            _isLoading.value = true
            val api = APIConfig.getAPIService().registUser(registDataUser)
            api.enqueue(object : Callback<Register> {
                override fun onResponse(
                    call: Call<Register>,
                    response: Response<Register>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _message.value = "Successful created account!"
                    } else {
                        when (response.code()) {
                            400 -> _message.value =
                                "Email ini sudah terdaftar, try again!"
                            408 -> _message.value =
                                "Koneksi internet buruk"
                            else -> _message.value = "Error: " + response.message()
                        }
                    }
                }

                override fun onFailure(call: Call<Register>, t: Throwable) {
                    _isLoading.value = false
                    _message.value = "Error: " + t.message.toString()
                }

            })
        }
    }

}