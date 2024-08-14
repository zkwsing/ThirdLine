package com.example.test2.kotlin.service

import com.example.test2.kotlin.bean.App
import retrofit2.Call
import retrofit2.http.GET

interface AppService {

    @GET("get_json")
    fun getAppData():Call<List<App>>
}