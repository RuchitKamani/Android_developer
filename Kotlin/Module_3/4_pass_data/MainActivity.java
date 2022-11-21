package com.example.a4_pass_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.t1);
        btn1=findViewById(R.id.b1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = e1.getText().toString();

                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("e1",str);
                startActivity(i);
            }
        });

    }
}