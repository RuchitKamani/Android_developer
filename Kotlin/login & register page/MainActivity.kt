package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var e1:EditText
    lateinit var e2:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        e1 = findViewById(R.id.edt1)
        e2 = findViewById(R.id.edt2)


        btn1.setOnClickListener {
           /* val i = Intent(this,register_form::class.java)
            startActivity(i)*/

            Toast.makeText(this,"login",Toast.LENGTH_SHORT).show()
        }
        btn2.setOnClickListener {
            val i = Intent(this,register_form::class.java)
            startActivity(i)
        }
    }
}