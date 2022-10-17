 package com.example.s_cafe_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

 public class Bill_Activity extends AppCompatActivity {

    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        txt1 = findViewById(R.id.txt1);

        Intent i = getIntent();
        String data = i.getStringExtra("ruchit");
      //  String data1 = i.getStringExtra("ruchit1");
        txt1.setText(data);
        //txt1.setText(data1);


    }
}