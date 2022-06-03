package com.example.kisahnabi.network

import com.example.kisahnabi.fragment.NabiFragment
import com.example.kisahnabi.model.ResponseNabiItem
import com.example.kisahnabi.model.ResponseRasulItem
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitService {
    //  Client Bertugas Sebagai Alat Penghubung ke Server
    private val client : OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://628d82f8a339dfef879bbb58.mockapi.io/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    fun getData() = retrofit.create(Nabi::class.java)

    interface Nabi {
        @GET("v1/nabi")

        fun getDataNabi(): Call<List<ResponseNabiItem>>
    }
}

object RetrofitServices {
    private val clients : OkHttpClient = OkHttpClient.Builder().build()

    private val retrofits : Retrofit = Retrofit.Builder()
        .baseUrl("https://628d82f8a339dfef879bbb58.mockapi.io/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(RetrofitServices.clients)
        .build()

    fun getDatas() = RetrofitServices.retrofits.create(Nabi::class.java)

    interface Nabi {
        @GET("v1/rasul")

        fun getDataRasul(): Call<List<ResponseRasulItem>>
    }
}