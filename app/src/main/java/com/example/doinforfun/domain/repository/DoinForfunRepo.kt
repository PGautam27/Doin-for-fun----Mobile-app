package com.example.doinforfun.domain.repository

import com.example.doinforfun.data.remote.dto.LoginRequest

interface DoinForfunRepo {

    suspend fun login(loginRequest: LoginRequest)

}