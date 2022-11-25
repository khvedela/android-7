package com.example.appretrofit.models.allUsers

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    val data: List<Data?>? = null,
    val page: Int? = null,
    @SerializedName("per_page")
    val perPage: Int? = null,
    val support: Support? = null,
    val total: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null
)