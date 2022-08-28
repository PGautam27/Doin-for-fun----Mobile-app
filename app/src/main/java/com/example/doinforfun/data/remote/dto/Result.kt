package com.example.doinforfun.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("__v")
    val __v: Int,
    @SerializedName("__id")
    val _id: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)