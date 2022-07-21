package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.num1);
        t2= findViewById(R.id.num2);
        i1=findViewById(R.id.img1);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num = t1.getText().toString();
                String pass = t2.getText().toString();

                if(num.length()==0 && pass.length()==0)
                {
                    t1.setError("Please Enter Name");
                    t2.setError("Please Enter Password");
                }
                if (num.length()==0)
                {
                    t1.setError("Please Enter Name");
                }
                if(pass.length()==0)
                {
                    t2.setError("Please Enter Password");
                }
                else
                {
                    if(num.equals("1234") && pass.equals("1234"))
                    {
                        Toast.makeText(MainActivity.this, "Success Login", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(MainActivity.this,order.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Retry", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}