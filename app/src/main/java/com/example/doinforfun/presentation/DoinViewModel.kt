package com.example.doinforfun.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doinforfun.data.remote.dto.LoginRequest
import com.example.doinforfun.data.remote.dto.LoginResponse
import com.example.doinforfun.data.repository.DoInForFunRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoinViewModel @Inject constructor(
    private val repoImpl: DoInForFunRepoImpl
) : ViewModel() {

    private val email = MutableLiveData<String>()
    private val password = MutableLiveData<String>()
    val at : LiveData<LoginResponse> get() = repoImpl.accessToken
    val token : LiveData<LoginResponse> = repoImpl._accessToken
    val ol : LiveData<String> get() = repoImpl._hola
    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            repoImpl.login(loginRequest)
        }
    }

}