package com.example.test2.kotlin.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceCreator {
    private const val BASE_URL = "http://bai.com"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> create(serviceClass: Class<T>):T = retrofit.create(serviceClass)
    inline fun <reified T> create():T = create(T::class.java)
}