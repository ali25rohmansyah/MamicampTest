package com.raproject.mamicamptest.network

import com.squareup.moshi.Json

data class GenreData(
    @Json(name = "resource") val result: List<GenreDataResult>
)