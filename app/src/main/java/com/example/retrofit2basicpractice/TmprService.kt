package com.example.retrofit2basicpractice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmprService {
    @GET("TmprScrnIspcOfic")
    fun getTmprData(@Query("KEY") KEY : String,
                    @Query("Type") Type : String): Call<TmprResponse>
}