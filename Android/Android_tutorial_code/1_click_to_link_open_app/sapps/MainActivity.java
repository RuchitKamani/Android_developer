package com.example.sapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaration

    ImageView instagram, twitter , whatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initilization
        instagram = findViewById(R.id.instageam);
        twitter = findViewById(R.id.twitter);
        whatsapp = findViewById(R.id.whatsapp);

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Only 5 minute use", Toast.LENGTH_SHORT).show();

           /*

            Types of Intent:
            1)Explicit:switching from one activity to another activity in same app
            2)Implicit :switching from one activity to another activity between diffrent app

            */
                String urlinsta = "https://www.instagram.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urlinsta));
                startActivity(i);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Only 5 minute use", Toast.LENGTH_SHORT).show();

                String urltwit = "https://www.twitter.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(urltwit));
                startActivity(i);
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Only five minute use", Toast.LENGTH_SHORT).show();

                String uriwhatsapp = "https://www.whatsapp.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(uriwhatsapp));
                startActivity(i);

            }
        });
    }
}