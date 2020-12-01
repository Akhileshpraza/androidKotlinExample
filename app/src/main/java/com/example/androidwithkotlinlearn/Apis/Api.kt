package com.example.androidwithkotlinlearn.Apis

import android.widget.EditText
import com.example.androidwithkotlinlearn.DefaultResponce
import com.example.androidwithkotlinlearn.Modals.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("createuser")
    fun createUser(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("school") school: String
    ): Call<DefaultResponce>

    @FormUrlEncoded
    @POST("userlogin")
    fun userlogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}