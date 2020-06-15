package com.raproject.mamicamptest.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private val baseUrl = "https://cabaca.id:8443/api/v2/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(baseUrl)
    .build()

// Api interface / Endpoint
interface CabacaService{
    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/uptodate?limit=10")
    suspend fun showUpdateBook():
            ActionData

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/category?id=1")
    suspend fun showActions():
            ActionData
}

object cabacaApi{
    val retrofitServic: CabacaService = retrofit.create(CabacaService::class.java)
}