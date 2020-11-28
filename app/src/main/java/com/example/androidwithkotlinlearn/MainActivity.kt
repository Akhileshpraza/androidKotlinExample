package com.example.androidwithkotlinlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView = findViewById<ListView>(R.id.listview)

        var rf = Retrofit.Builder()
            .baseUrl(RetrofitInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        var API =rf.create(RetrofitInterface::class.java)
        var call =API.posts

        call?.enqueue(object :Callback<List<Modal?>?>{
            override fun onResponse(call: Call<List<Modal?>?>, response: Response<List<Modal?>?>) {
                var postlist : List<Modal>? = response.body() as List<Modal>
                var post = arrayOfNulls<String>(postlist!!.size)

                for (i in postlist!!.indices)
                    post[i] = postlist!![i]!!.title

                var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,post)
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Modal?>?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Request failed " , Toast.LENGTH_SHORT).show()
            }

        })
    }
}