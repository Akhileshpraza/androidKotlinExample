package com.example.androidwithkotlinlearn.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.androidwithkotlinlearn.Apis.RetrofitClient
import com.example.androidwithkotlinlearn.Modals.LoginResponse
import com.example.androidwithkotlinlearn.R
import com.example.androidwithkotlinlearn.Storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val password =findViewById<EditText>(R.id.editTextPassword)
        val tvsignup = findViewById<TextView>(R.id.textViewRegister)

        tvsignup.setOnClickListener {
            startActivity(Intent(this@LoginActivity,SignupActivity::class.java))
        }



        buttonLogin.setOnClickListener {

            val Email =email.text.toString().trim()
            val Password =password.text.toString().trim()

            if (Email.isEmpty()){
                email.error ="Email required"
                email.requestFocus()
                return@setOnClickListener
            }

            if (Password.isEmpty()){
                password.error ="Password required"
                password.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.userlogin(Email,Password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>
                    ) {
                        if (!response.body()?.error!!){

                            val intent=Intent(applicationContext,ProfileActivity::class.java)
                            intent.flags =Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }
                        else{
                                Toast.makeText(applicationContext,response.body()?.message,Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()
                    }

                })

        }
    }

    override fun onStart() {
        super.onStart()

        if(SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, ProfileActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }
}