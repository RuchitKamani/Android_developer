package com.example.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    btn3=findViewById(R.id.btn3);

    btn3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Toast.makeText(MainActivity3.this, "End", Toast.LENGTH_SHORT).show();
        }
    });

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}