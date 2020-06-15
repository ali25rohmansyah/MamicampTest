package com.raproject.mamicamptest.network

import com.squareup.moshi.Json

data class ActionData(
    @Json(name = "result") val results: List<ActionDataResult>
)
