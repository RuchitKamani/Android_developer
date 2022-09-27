package com.example.realm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    e1=findViewById(R.id.e1);
    e2=findViewById(R.id.e2);
    b1=findViewById(R.id.b1);
    b2=findViewById(R.id.b2);
    realm=Realm.getInstance(Realm.getDefaultConfiguration());

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String name=e1.getText().toString();
            String number=e2.getText().toString();

            realm.beginTransaction();

            Model m=realm.createObject(Model.class);
            m.setName(name);
            m.setNumber(number);

            realm.commitTransaction();
            Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
        }
    });

    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(i);
        }
    });



    }
}