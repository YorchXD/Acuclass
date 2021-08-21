package com.example.acuclass.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://yorch.rayunmapu.cl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}