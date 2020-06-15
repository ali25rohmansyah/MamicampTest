package com.raproject.mamicamptest.network

data class DetailBookDataResult(
    val id: String,
    val title: String,
    val cover_url: String,
    val status: String,
    val writer_id: String,
    val desc: String?
    )