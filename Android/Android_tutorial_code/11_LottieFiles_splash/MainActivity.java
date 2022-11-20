package com.example.a11_lottiefiles_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

           }
       },3000);
    }
}