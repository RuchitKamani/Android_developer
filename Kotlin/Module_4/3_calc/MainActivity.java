package com.example.a3_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edtfirstnum,edtsecondnum;
    Button btncalc;
    TextView txt1;
    RadioButton r1,r2,r3,r4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtfirstnum = findViewById(R.id.firstnum);
        edtsecondnum = findViewById(R.id.secondnum);
        txt1 = findViewById(R.id.txt1);
        btncalc = findViewById(R.id.btncalc);
        r1=findViewById(R.id.add);
        r2 = findViewById(R.id.sub);
        r3 = findViewById(R.id.mul);
        r4 = findViewById(R.id.div);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int first = Integer.parseInt(edtfirstnum.getText().toString());
                int second = Integer.parseInt(edtsecondnum.getText().toString());



                if (r1.isChecked())
                {
                    int ans = first+second;
                    String ans1 = String.valueOf(ans);
                    Toast.makeText(MainActivity.this, ""+ans, Toast.LENGTH_SHORT).show();
                    txt1.setText(ans1);
                }
                else if(r2.isChecked())
                {
                    int ans = first-second;
                    String ans1 = String.valueOf(ans);
                    Toast.makeText(MainActivity.this, ""+ans, Toast.LENGTH_SHORT).show();
                    txt1.setText(ans1);
                }
                else if(r3.isChecked())
                {
                    int ans = first*second;
                    String ans1 = String.valueOf(ans);
                    Toast.makeText(MainActivity.this, ""+ans, Toast.LENGTH_SHORT).show();
                    txt1.setText(ans1);
                }
                else if(r4.isChecked())
                {
                    int ans = first/second;
                    String ans1 = String.valueOf(ans);
                    Toast.makeText(MainActivity.this, ""+ans, Toast.LENGTH_SHORT).show();
                    txt1.setText(ans1);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Enter Number", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}