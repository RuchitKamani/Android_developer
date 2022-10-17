package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.s_alert_dialog.R;

import java.util.jar.Attributes;

public class Login_form extends AppCompatActivity {

    EditText name, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        login = findViewById(R.id.login);
        name = findViewById(R.id.name);
        password = findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e1 = name.getText().toString();
                String e2 = password.getText().toString();

                if (e1.length()==0)
                {
                    name.setError("Enter name (a)");

                }
                else if (e2.length()==0)
                {
                    password.setError("Enter surname (1)");
                }
                else
                {
                    if (e1.equals("a") && e2.equals("1"))
                    {
                        Intent i = new Intent(Login_form.this, first_page.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(Login_form.this, "Please chack name & password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}