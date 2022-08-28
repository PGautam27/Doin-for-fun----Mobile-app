package com.example.doinforfun.di

import com.example.doinforfun.data.remote.DoinForFunApi
import com.example.doinforfun.data.repository.DoInForFunRepoImpl
import com.example.doinforfun.domain.repository.DoinForfunRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun doInForFunApi(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://fun-node.herokuapp.com/api/v1")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build())
        .build()

    @Provides
    fun providesGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideDoinForFunService(retrofit: Retrofit):DoinForFunApi = retrofit.create(DoinForFunApi::class.java)

    @Provides
    @Singleton
    fun providesDoInForFunRepo(api:DoinForFunApi) : DoinForfunRepo{
        return DoInForFunRepoImpl(api)
    }
}

