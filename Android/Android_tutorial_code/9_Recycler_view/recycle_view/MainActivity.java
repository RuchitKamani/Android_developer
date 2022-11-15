package com.example.recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //Declaration
    RecyclerView recyclerView;  //create model calss
    List<Model_class> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization

        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();

        //move to Model class but first design xml
            RecyclerView.LayoutManager rl = new GridLayoutManager(MainActivity.this, 2);
            recyclerView.setLayoutManager(rl);


        int v = 10;

        for (int i = 1; i < v; i++) {
            list.add(new Model_class(R.drawable.one, "class", "one"));
            list.add(new Model_class(R.drawable.two, "class", "two"));
            list.add(new Model_class(R.drawable.three, "class", "three"));
        }

        //creat Adapter class

        //declaration
        Adapter_class adapter_class = new Adapter_class(getApplicationContext(), list);
        recyclerView.setAdapter(adapter_class);

    }
}