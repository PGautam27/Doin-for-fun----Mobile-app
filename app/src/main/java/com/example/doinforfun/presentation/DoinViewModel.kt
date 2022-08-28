package com.example.doinforfun.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doinforfun.data.LoginRequest
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
    val at : LiveData<String> = repoImpl.accessToken

    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            repoImpl.login(loginRequest)
        }
    }

}