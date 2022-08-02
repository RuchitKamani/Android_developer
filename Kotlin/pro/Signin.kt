package com.example.myapplication.SignandSplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.TimePicker
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySigninBinding
import com.example.myapplication.mainpage.homepage


class Signin : AppCompatActivity() {


    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)
       val view = binding.root
        setContentView(view)

        // setContentView(binding.root)
        emailFocusListener() // my create mothed
        passwordListener()
        var numandemail = binding.emailandnumber.handler == null
        var password = binding.password.handler == null

        binding.loginbtn.setOnClickListener()
        {
            if (numandemail && password)
            {
                Toast.makeText(this,"no", Toast.LENGTH_SHORT).show()

            }
            else{
                startActivity(Intent(this,homepage::class.java))
            }


        }
    }




    private fun emailFocusListener() {
        binding.emailandnumber.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus)
            {
                binding.emailcontainer.helperText = validEmail() // my create
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.emailandnumber.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid Email Address"
        }
            return null
    }
    private fun passwordListener() {
        binding.password.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus)
            {
                binding.passwordcontarner.helperText = valpassword()
            }
        }
    }

    private fun valpassword(): String? {
        val passwordText = binding.password.text.toString()
        if (passwordText.length < 8)
        {
            return "Minimum 8 Character Password"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if (!passwordText.matches(".*[!@#$%^&*_+].*".toRegex()))
        {
            return "Must Contain Special Character (!@#$%^&*_+) "
        }
        return null
    }
}