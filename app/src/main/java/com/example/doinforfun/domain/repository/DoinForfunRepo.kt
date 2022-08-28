package com.example.doinforfun.domain.repository

import com.example.doinforfun.data.LoginRequest

interface DoinForfunRepo {

    suspend fun login(loginRequest: LoginRequest)

}