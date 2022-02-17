package com.example.retrofit2basicpractice

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmprService {
    @GET("TmprScrnIspcOfic")
    fun getTmprData(@Query("KEY") KEY : String,
                    @Query("Type") Type : String): Call<TmprResponse>

    // Coroutine으로 작동하는 Service
    @GET("TmprScrnIspcOfic")
    suspend fun getDataCoroutine(
        @Query("KEY") KEY : String,
        @Query("Type") Type : String
    ): Response<TmprResponse>
}