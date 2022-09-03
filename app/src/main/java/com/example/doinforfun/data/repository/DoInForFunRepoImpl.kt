package com.example.doinforfun.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
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
    val _accessToken : LiveData<LoginResponse> = accessToken
    val hola = MutableLiveData<String>("hola")
    val _hola = hola

    override suspend fun login(loginRequest: LoginRequest) {
        try {
            accessToken.postValue(api.login(loginRequest))
            Log.v("Workin","It's workin")
        } catch (e : Exception){
            Log.v("Workin", "Not working")
            hola.value = "Broke"
        }
    //            .onSuccess { result ->
//                accessToken.postValue(result)
//                hola.value = "alolalalalala"
//                Log.v("Workin","It's workin")
//            }
//            .onFailure {
//                hola.value = "Failure"
//                Log.v("Workin","not workin")
//            }
    }

}