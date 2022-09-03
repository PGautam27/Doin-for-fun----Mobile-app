package com.example.doinforfun.data.remote

import com.example.doinforfun.data.remote.dto.LoginRequest
import com.example.doinforfun.data.remote.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface DoinForFunApi {

    @POST("auth/login/")
    suspend fun login(@Body loginRequest: LoginRequest) : LoginResponse

}