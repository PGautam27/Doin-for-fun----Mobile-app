package com.example.doinforfun.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("result")
    val result: Result,
    @SerializedName("token")
    val token: String
)