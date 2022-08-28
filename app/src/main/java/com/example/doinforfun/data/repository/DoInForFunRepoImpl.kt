package com.example.doinforfun.data.repository

import com.example.doinforfun.data.LoginRequest
import com.example.doinforfun.data.remote.DoinForFunApi
import com.example.doinforfun.domain.repository.DoinForfunRepo
import javax.inject.Inject

class DoInForFunRepoImpl @Inject constructor(
    private val api : DoinForFunApi
): DoinForfunRepo {

    override suspend fun login(loginRequest: LoginRequest) {
        api.login(loginRequest)
    }

}