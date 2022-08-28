package com.example.doinforfun.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.doinforfun.data.remote.dto.LoginRequest
import com.example.doinforfun.data.remote.DoinForFunApi
import com.example.doinforfun.data.remote.dto.LoginResponse
import com.example.doinforfun.domain.repository.DoinForfunRepo
import javax.inject.Inject

class DoInForFunRepoImpl @Inject constructor(
    private val api : DoinForFunApi
): DoinForfunRepo {

    val accessToken = MutableLiveData<LoginResponse>()

    override suspend fun login(loginRequest: LoginRequest) {
        api.login(loginRequest)
            .onSuccess { result ->
                accessToken.value = result
            }
            .onFailure {

            }
    }

}