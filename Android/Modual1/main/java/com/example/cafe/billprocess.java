package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class billprocess extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billprocess);

        text=findViewById(R.id.text);

        Intent i =getIntent();
        String data=i.getStringExtra("tops");

        text.setText(data);
    }
}