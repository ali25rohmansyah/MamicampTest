package com.raproject.mamicamptest.network

import com.squareup.moshi.Json

data class DetailUserData(
    @Json(name = "result") val result: DetailUserDataResult
)