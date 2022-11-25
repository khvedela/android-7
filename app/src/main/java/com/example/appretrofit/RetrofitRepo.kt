package com.example.appretrofit

import com.example.appretrofit.models.SingleUser
import com.example.appretrofit.models.allUsers.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitRepo {
    @GET("api/users?page=2")
    suspend fun getAllUsers(): Response<ResponseModel>

    @GET("api/users/{id}")
    suspend fun getSingleUser(@Path("id") id: Int): Response<SingleUser>
}