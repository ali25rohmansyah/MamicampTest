package com.raproject.mamicamptest.network

import com.squareup.moshi.Json

data class BooksData(
    @Json(name = "result") val results: List<BookDataResult>
)
