package com.example.androidwithkotlinlearn.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.example.androidwithkotlinlearn.R
import com.example.androidwithkotlinlearn.RetrofitInterface
import com.example.androidwithkotlinlearn.Modals.postModal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        var textview = findViewById<TextView>(R.id.textview)
        //Retrofit Builder
         val retrofitbuilder =Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl(RetrofitInterface.BASE_URL)
             .build()

        //post
//        val JsonAPI = retrofitbuilder.create(RetrofitInterface::class.java)
//        val postdata  =postModal(1,1,"Post Data","Hii Akhilesh ")
//        val call= JsonAPI.sendData(postdata)

//        call.enqueue(object: Callback<postModal>{
//            override fun onResponse(call: Call<postModal>, response: Response<postModal>) {
//                textview.text = response.code().toString()
//            }
//            override fun onFailure(call: Call<postModal>, t: Throwable) {
//                textview.text =t.message.toString()
//            }
//        } )

        //Update
//        val update = retrofitbuilder.create(RetrofitInterface::class.java)
//
//        val postdata  = postModal(1,1,"Delete Data","Hii Akhilesh ")//dumi data
//        val call= update.put(5,postdata)
//
//
//        call.enqueue(object: Callback<postModal>{
//            override fun onResponse(call: Call<postModal>, response: Response<postModal>) {
//                textview.text = response.code().toString()
//            }
//
//            override fun onFailure(call: Call<postModal>, t: Throwable) {
//                textview.text =t.message.toString()
//            }
//        } )


        //delete
        val update = retrofitbuilder.create(RetrofitInterface::class.java)

        val postdata  = postModal(1,1,"update data","Hii Akhilesh ")//dumi data
        val call= update.delete(5)


        call.enqueue(object: Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                textview.text = response.code().toString()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                textview.text =t.message.toString()
            }
        } )


    }
}