package com.example.appretrofit.models.allUsers

import com.google.gson.annotations.SerializedName

data class Data(
    val avatar: String? = null,
    val email: String? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    val id: Int? = null,
    @SerializedName("last_name")
    val lastName: String? = null
)