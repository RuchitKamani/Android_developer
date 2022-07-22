package com.example.reverse_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1;
    HashMap<Character , Integer>charHas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);
        t1=findViewById(R.id.t1);
        charHas = new HashMap<>();

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer stringBuffer = new StringBuffer(e1.getText().toString());
                t1.setText(stringBuffer.reverse());
            }
        });




    }
}