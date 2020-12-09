package com.example.androidwithkotlinlearn.Fragment

import android.content.Context
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidwithkotlinlearn.R


class Fragment_two : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Return the fragment view/layout
        return inflater!!.inflate(R.layout.fragmnet_two,container,false)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}




//import android.app.Fragment
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.androidwithkotlinlearn.R
//import java.util.zip.Inflater
//
//class Fragment_two : Fragment(){
//
//    override fun onCreateView(
//        inflater: LayoutInflater?,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view = inflater?.inflate(R.layout.fragmnet_two,container,false)
//
//        return view
//    }
//
//}