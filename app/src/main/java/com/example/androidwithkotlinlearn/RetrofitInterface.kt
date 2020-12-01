package com.example.androidwithkotlinlearn

import com.example.androidwithkotlinlearn.Modals.Modal
import com.example.androidwithkotlinlearn.Modals.postModal
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    //get data
    @get:GET("posts")
    val posts : Call<List<Modal?>?>?

    //post data
    @POST("posts")
    fun sendData(@Body postModal: postModal):Call<postModal>

    //Delete data
    @DELETE ("posts/{id}")
    fun delete(@Path("id") id:Int):Call<Unit>

    //update

    @PUT("posts/{id}")
    fun put(
            @Path("id") id:Int,
            @Body postModal: postModal
    ):Call<postModal>


    companion object{
        const val BASE_URL ="https://jsonplaceholder.typicode.com/"
    }
}