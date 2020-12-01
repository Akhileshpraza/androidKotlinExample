package com.example.androidwithkotlinlearn.Apis

import android.util.Base64
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val AUTH ="Basic "+Base64.encodeToString("belalkhan:123456".toByteArray(),Base64.NO_WRAP)

    private  const val BASE_Url ="http://192.168.43.202/myapi/public/"

    private val OkHttpClient =okhttp3.OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original =chain.request()
                val requestBuilder =original.newBuilder()
                        .addHeader("Authorization", AUTH)
                        .method(original.method(),original.body())

                val request =requestBuilder.build()
                chain.proceed(request)
            }.build()

    val instance : Api by lazy {
        val retrofit =Retrofit.Builder()
                .baseUrl(BASE_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient)
                .build()
        retrofit.create(Api::class.java)
    }
}