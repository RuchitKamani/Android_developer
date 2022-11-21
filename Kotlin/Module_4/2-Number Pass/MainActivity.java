package com.example.two_number_sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    e1=findViewById(R.id.edt1);
    e2=findViewById(R.id.edt2);
    b1=findViewById(R.id.btn1);
    t1=findViewById(R.id.t1);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int a=Integer.parseInt(e1.getText().toString());
            int b=Integer.parseInt(e2.getText().toString());

            int c=a+b;

            t1.setText("sum "+c);
            Toast.makeText(MainActivity.this, "sum is  "+c, Toast.LENGTH_SHORT).show();
        }
    });


    }
}