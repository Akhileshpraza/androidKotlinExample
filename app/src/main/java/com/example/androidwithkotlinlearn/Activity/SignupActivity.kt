package com.example.androidwithkotlinlearn.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.androidwithkotlinlearn.Apis.RetrofitClient
import com.example.androidwithkotlinlearn.DefaultResponce
import com.example.androidwithkotlinlearn.R
import com.example.androidwithkotlinlearn.Storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val buttonSignUp = findViewById<Button>(R.id.buttonSignUp)
        val etemail = findViewById<EditText>(R.id.editTextEmail);
        val etname = findViewById<EditText>(R.id.editTextName);
        val etpassword = findViewById<EditText>(R.id.editTextPassword);
        val etschool = findViewById<EditText>(R.id.editTextSchool);
        val tvlogin = findViewById<TextView>(R.id.textViewLogin);

        tvlogin.setOnClickListener {
            startActivity(Intent(this@SignupActivity,LoginActivity::class.java))
        }
        buttonSignUp.setOnClickListener {

            val Email =etemail.text.toString().trim()
            val Name = etname.text.toString().trim()
            val Password = etpassword.text.toString().trim()
            val School = etschool.text.toString().trim()

            if (Email.isEmpty()){
                etemail.error ="Email required"
                etemail.requestFocus()
                return@setOnClickListener
            }

            if (Name.isEmpty()){
                etname.error ="Name required"
                etname.requestFocus()
                return@setOnClickListener
            }

            if (Password.isEmpty()){
                etpassword.error ="Password required"
                etpassword.requestFocus()
                return@setOnClickListener
            }

            if (School.isEmpty()){
                etschool.error ="School required"
                etschool.requestFocus()
                return@setOnClickListener
            }

           RetrofitClient.instance.createUser(Email,Name,Password,School)
               .enqueue(object : Callback<DefaultResponce> {
                   override fun onResponse(call: Call<DefaultResponce>, response: Response<DefaultResponce>) {
                       Toast.makeText(applicationContext,response.body()?.message,Toast.LENGTH_LONG).show()
                   }

                   override fun onFailure(call: Call<DefaultResponce>, t: Throwable) {
                       Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
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