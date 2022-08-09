package com.example.topsproject.lointosplash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.topsproject.Activity.Dashbord
import com.example.topsproject.R
import com.example.topsproject.Retrofit.Apiclient
import com.example.topsproject.Retrofit.Apiinterface
import com.example.topsproject.databinding.ActivitySigninActiviyBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Response

class SigninActiviy : AppCompatActivity() {

    private lateinit var binding: ActivitySigninActiviyBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninActiviyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        passwordListener()



        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("user_session", false) && !sharedPreferences.getString("sharedkey", "")!!.isEmpty())
        {
            startActivity(Intent(this, Dashbord::class.java))
        }



        binding.loginbtn.setOnClickListener()
        {

            var number = binding.emailandnumber.text.toString()
            // var email = binding.emailandnumber.text.toString()
            var password = binding.password.text.toString()


            if (binding.emailandnumber.length() == 0) {
                binding.emailandnumber.error = "name"
            } else if (binding.password.length() == 0) {
                binding.password.error = "pass"
            } else {

                if (binding.password.length() >= 2 && binding.emailandnumber.length() >= 2) {

                    /*.....database insert data code.....*/

                    apiinterface = Apiclient.getapiclient().create(Apiinterface::class.java)
                    var call: retrofit2.Call<Void> =
                        apiinterface.logindata(number, password)
                    call.enqueue(object : retrofit2.Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            sharedPreferences.edit().putString("sharedkey",number).commit()
                            sharedPreferences.edit().putBoolean("user_session",true).commit();

                            startActivity(Intent(this@SigninActiviy, Dashbord::class.java))
                            // Toast.makeText(applicationContext, "insert", Toast.LENGTH_LONG).show()

                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            // Toast.makeText(this@Signin, "Chack internet", Toast.LENGTH_LONG).show()
                            Snackbar.make(it, "Chack Internet & Data", Snackbar.LENGTH_LONG).show()
                        }
                    })

                } else {
                    Toast.makeText(this@SigninActiviy, "Login Fail", Toast.LENGTH_SHORT).show()
                }
            }


        }

        binding.registerbtn.setOnClickListener(){
            startActivity(Intent(this,Singup_Activity::class.java))
        }
    }

    private fun passwordListener() {
        binding.password.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                binding.passwordcontarner.helperText = valpassword()
            }
        }
    }

    private fun valpassword(): String? {
        val passwordText = binding.password.text.toString()
        if (passwordText.length < 8) {
            return "Minimum 8 Character Password"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Must Contain 1 Upper-case Character"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Must Contain 1 Lower-case Character"
        }
        if (!passwordText.matches(".*[!@#$%^&*_+].*".toRegex())) {
            return "Must Contain Special Character (!@#$%^&*_+) "
        }
        return null


    }

}