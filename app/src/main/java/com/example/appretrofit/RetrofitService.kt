package com.example.appretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://reqres.in/"

    fun service(): RetrofitRepo {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitRepo::class.java)
    }

}