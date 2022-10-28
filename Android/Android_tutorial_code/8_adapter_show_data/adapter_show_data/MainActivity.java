package com.example.adapter_show_data;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //1. first xml listview
    //2. Declaration & initialization
    //3. design xml
    //4. Model class
    //5. Adapter
    //6. MainActivity.java coding

    ListView listView;
    List<Modelclass> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list_item);
        list = new ArrayList<>();

       // list.add(new Modelclass(R.drawable.one,"abc"));


        list.add(new Modelclass(R.drawable.one,"one"));
        list.add(new Modelclass(R.drawable.two,"two"));
        list.add(new Modelclass(R.drawable.three,"three"));


        //Multiple value show use  loop

        int value=10;
        for (int i = 1; i<=value; i++)
        {
            list.add(new Modelclass(R.drawable.one,"one"));
            list.add(new Modelclass(R.drawable.two,"two"));
            list.add(new Modelclass(R.drawable.three,"three"));
        }



        Adapter adapter = new Adapter(getApplicationContext(),list);
        listView.setAdapter(adapter);

    }
}