package com.example.doinforfun.di

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


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun doInForFunApi(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://fun-node.herokuapp.com/api/v1/user/login")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build())
        .build()

    @Provides
    fun providesGson(): Gson = GsonBuilder().create()
}

