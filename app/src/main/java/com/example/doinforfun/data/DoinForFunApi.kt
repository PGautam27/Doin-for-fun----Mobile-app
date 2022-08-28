package com.example.doinforfun.data

import retrofit2.http.Body
import retrofit2.http.POST

interface DoinForFunApi {

    @POST("/user/login")
    suspend fun login(@Body loginRequest: LoginRequest) : Result<LoginResponse>

}