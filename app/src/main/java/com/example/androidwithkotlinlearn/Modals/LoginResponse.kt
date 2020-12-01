package com.example.androidwithkotlinlearn.Modals

data class LoginResponse (val error: Boolean, val message:String, val user: User)