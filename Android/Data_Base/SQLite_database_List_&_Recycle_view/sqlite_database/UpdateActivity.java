package com.example.sqlite_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);

        myDBHelper=new MyDBHelper(getApplicationContext());

        Intent i =getIntent();
        int id=i.getIntExtra("id",101);
        edt1.setText(i.getStringExtra("name"));
        edt2.setText(i.getStringExtra("number"));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=edt1.getText().toString();
                String num=edt2.getText().toString();

                ContactModel m =new ContactModel();
                m.setId(id);
                m.setName(name);
                m.setPhone_no(num);

                myDBHelper.Update(m);
                startActivity(new Intent(UpdateActivity.this,View_data.class));


            }
        });
    }
}