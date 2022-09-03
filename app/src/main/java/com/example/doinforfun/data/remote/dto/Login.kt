package com.example.doinforfun.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("phone")
    val phone: Int,

    @SerializedName("password")
    val password: String
)
