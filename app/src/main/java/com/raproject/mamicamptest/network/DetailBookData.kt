package com.raproject.mamicamptest.network

import com.squareup.moshi.Json

data class DetailBookData(
    @Json(name = "result") val result: DetailBookDataResult
)