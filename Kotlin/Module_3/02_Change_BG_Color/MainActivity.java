package com.example.a2_change_bg_color;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnorange,btnblack,btngreen,btnblue;
    View myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnorange=findViewById(R.id.btnorange);
        btnblack=findViewById(R.id.btnblack);
        btngreen=findViewById(R.id.btngreen);
        btnblue=findViewById(R.id.btnblue);

        myview=findViewById(R.id.view);


        btnorange.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.orange));
            }
        });

        btnblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
            }
        });

        btngreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.green));
            }
        });

        btnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue));
            }
        });

    }
}