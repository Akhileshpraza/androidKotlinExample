package com.example.androidwithkotlinlearn.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.androidwithkotlinlearn.Fragment.Fragment_one
import com.example.androidwithkotlinlearn.Fragment.Fragment_two
import com.example.androidwithkotlinlearn.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

//        button1.setOnClickListener {
//            loadfrag1(Fragment_one())
//        }
//        button2.setOnClickListener {
//            loadfrag2(Fragment_two())
//        }

        // Set a click listener for first button widget
        button1.setOnClickListener {
            // Get the text fragment instance
            val textFragment = Fragment_one()

            // Get the support fragment manager instance
            val manager = supportFragmentManager

            // Begin the fragment transition using support fragment manager
            val transaction = manager.beginTransaction()

            // Replace the fragment on container
            transaction.replace(R.id.fragment_container,textFragment)
            transaction.addToBackStack(null)

            // Finishing the transition
            transaction.commit()
        }


        // Set a click listener for second button widget
        button2.setOnClickListener {
            // Get the text fragment instance
            val imageFragment = Fragment_two()

            // Get the support fragment manager instance
            val manager = supportFragmentManager

            // Begin the fragment transition using support fragment manager
            val transaction = manager.beginTransaction()

            // Replace the fragment on container
            transaction.replace(R.id.fragment_container,imageFragment)
            transaction.addToBackStack(null)

            // Finishing the transition
            transaction.commit()
        }

    }

//    fun loadfrag1 (frag1 : Fragment_one){
//        val ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.fragment, Fragment())
//        ft.commit()
//    }
//
//
//
//    fun loadfrag2 (frag2 :Fragment_two){
//        val ft =supportFragmentManager.beginTransaction()
//        ft.replace(R.id.fragment,Fragment())
//        ft.commit()
//    }
}




