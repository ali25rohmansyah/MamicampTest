package com.raproject.mamicamptest.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

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
    @GET("book/uptodate?limit=42")
    suspend fun showUpdateBook():
            BooksData

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/category?id=5")
    suspend fun showActions():
            BooksData

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/category?id=1")
    suspend fun showRomance():
            BooksData

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/detail/{id}")
    suspend fun showDetailBook(@Path("id") id: String):
            DetailBookData

    @Headers("x-dreamfactory-api-key: 25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("writer/detail/{id}")
    suspend fun showDetailUser(@Path("id") id: String):
            DetailUserData

}

object cabacaApi{
    val retrofitServic: CabacaService = retrofit.create(CabacaService::class.java)
}