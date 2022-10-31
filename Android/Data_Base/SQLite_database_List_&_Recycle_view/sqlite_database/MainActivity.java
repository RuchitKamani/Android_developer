package com.example.sqlite_database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1,btn2;
    MyDBHelper myDBHelper;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edt1=findViewById(R.id.name);
        edt2=findViewById(R.id.num);
        btn1=findViewById(R.id.insert);
        btn2=findViewById(R.id.view);

        myDBHelper= new MyDBHelper(MainActivity.this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = edt1.getText().toString();
                String Num = edt2.getText().toString();

                ContactModel m= new ContactModel();
                m.setName(Name);
                m.setPhone_no(Num);

                long id = myDBHelper.Insert(m);

                Toast.makeText(MainActivity.this, ""+id, Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,View_data.class);
                startActivity(i);
            }
        });


        /*MyDBHelper dbHelper =  new MyDBHelper(this);

        dbHelper.addContact("shree ram","123sda");
        dbHelper.addContact("shree sd ram","12asd3");


        ArrayList<ContactModel> arraycontact = dbHelper.fetchContact();

        for (int i=0; i<arraycontact.size(); i++)
        {
            Log.d("CONTACT_INFO","Name: "
                    +arraycontact.get(i).name + " Phone No: "
                    +arraycontact.get(i).phone_no);

        }*/
    }
}