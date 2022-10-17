package com.example.s_cafe_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {

    EditText name, mobile, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Mono = mobile.getText().toString();
                String Pass = pass.getText().toString();

                if (Name.length()==0)
                {
                    name.setError("Enter name");
                }
                else if (Mono.length()==0)
                {
                    mobile.setError("ENter mobile number");
                }
                else if (Pass.length()==0)
                {
                    pass.setError("Enter password");
                }
                else {
                    if (Pass.equals("123"))
                    {
                        Intent i = new Intent(Login_page.this,order_page.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(Login_page.this, "Chack Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}