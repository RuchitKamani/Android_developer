package com.example.topsproject.lointosplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.topsproject.R
import com.example.topsproject.Retrofit.Apiclient
import com.example.topsproject.Retrofit.Apiinterface
import com.example.topsproject.databinding.ActivitySingupAciityBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class Singup_Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySingupAciityBinding

    lateinit var apiinterface: Apiinterface
    private val passworpattern = "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%]).{6,20})"
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private var mAuth: FirebaseAuth? = null
    var varificationId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup_aciity)


        binding = ActivitySingupAciityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.singup.setOnClickListener {


            var name = binding.fullname.text.toString()
            var number = binding.number.text.toString()
            var email = binding.emailidsignup.text.toString()
            var password = binding.password.text.toString()
            var conformPassword = binding.conformpassword.text.toString()

            try {

                if (name.length == 0) {
                    binding.namecontainer.error = "Fill Your name"

                } else if (number.length == 0) {
                    binding.numbercontainer.error = "Ten Number Enter"
                    if (number.isEmpty()) {
                        binding.number.error = null

                    }

                } else if (!Patterns.EMAIL_ADDRESS.matcher((email.length == 0).toString()).matches()) {
                    binding.emailcontainersignup.error = "Enater Email"
                    if (email.isEmpty()) {
                        binding.emailidsignup.error = null
                    }
                } else if (password.matches(passworpattern.toRegex()) == false) {
                    binding.password.error = "Valid password"
                } else if (password.length == 0 && conformPassword.length == 0) {
                    binding.passwordcontainer.error = "Enter password"
                    binding.conformpasswordcontainer.error = "Enter Password"
                } else {
                    if (binding.password != binding.conformpassword) {

                        apiinterface = Apiclient.getapiclient().create(Apiinterface::class.java)
                        val call: Call<Void> = apiinterface.signup(name, number, email, password)
                        call.enqueue(object : Callback<Void> {
                            override fun onResponse(
                                call: Call<Void>,
                                response: Response<Void>,
                            ) {
                                Toast.makeText(this@Singup_Activity, "insert", Toast.LENGTH_SHORT).show()
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {
                                Toast.makeText(this@Singup_Activity, "" + t.message, Toast.LENGTH_SHORT).show()

                                // Log.d("XyzError",t.message.toString())
                            }

                        })
                        verifycode(binding.otpEdittext.getText().toString())

                    } else {
                        Toast.makeText(this, "no value", Toast.LENGTH_LONG).show()
                    }

                }

            }
            catch (e:Exception){
                Toast.makeText(this,"no app run", Toast.LENGTH_SHORT).show()

            }
        }
        binding.gologinpage.setOnClickListener() {
            startActivity(Intent(this, SigninActiviy::class.java))
        }

        /* ............Firebase connect........*/

        binding.otpbutten.setOnClickListener() {
            if (TextUtils.isEmpty(binding.number.text.toString())) {
                Toast.makeText(this, "Enter Valid number", Toast.LENGTH_SHORT).show()
            } else {
                val number = binding.number.text.toString()
                sendvrifycode(number)
            }
        }
    }
    private fun sendvrifycode(number: String) {
        PhoneAuthProvider.getInstance()
            .verifyPhoneNumber(number, 60, TimeUnit.SECONDS, this, mCallVBack)
    }

    var mCallVBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                varificationId = s
            }

            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                val code = phoneAuthCredential.smsCode
                code?.let { verifycode(it) }
            }

            override fun onVerificationFailed(e: FirebaseException) {}
        }

    private fun verifycode(code: String) {
        val credential = PhoneAuthProvider.getCredential(varificationId!!, code)
        SingInWhithCredentinal(credential)
    }

    private fun SingInWhithCredentinal(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}