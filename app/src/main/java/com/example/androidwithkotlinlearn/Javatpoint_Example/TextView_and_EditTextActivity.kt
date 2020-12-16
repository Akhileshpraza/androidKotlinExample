package com.example.androidwithkotlinlearn.Javatpoint_Example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.androidwithkotlinlearn.R

class TextView_and_EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_and__edit_text)
        val tv1 =findViewById<TextView>(R.id.textview)
        val Edtext = findViewById<EditText>(R.id.editText)
        val tv5 = findViewById<TextView>(R.id.textView5)
        val tv4 = findViewById<TextView>(R.id.textView4)
        val Btn = findViewById<Button>(R.id.button)

        Btn.setOnClickListener(){
            val inputValue: String = Edtext.text.toString()
            if (inputValue==null || inputValue.trim()==""){
                Toast.makeText(this,"please input data",Toast.LENGTH_LONG).show()
            }
            else{
                tv4.setText(inputValue).toString()
            }
        }
            tv5.setOnClickListener(){
                if(tv4.text.toString()==null || tv4.text.toString().trim()==""){
                    Toast.makeText(this,"clicked on reset textView,\n output textView already reset",Toast.LENGTH_LONG).show()
                }else{
                    tv4.setText("").toString()
                }
            }
        Edtext.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed before making any change over EditText",Toast.LENGTH_SHORT).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed while making any change over EditText",Toast.LENGTH_SHORT).show()
            }
            override fun afterTextChanged(p0: Editable?) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed after change made over EditText",Toast.LENGTH_SHORT).show()
            }
        })
    }
}