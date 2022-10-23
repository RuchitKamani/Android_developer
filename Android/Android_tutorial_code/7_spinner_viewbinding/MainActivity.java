package com.example.a7_spinner_viewbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a7_spinner_viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Binding code bild.gradle enter and synk now

    ActivityMainBinding binding;
    AppCompatSpinner spinner;
    //Spinner soinner; //simple
    String[] city = {"0 Rajkot", "1 Surat", "2 Ahmedabad", "3 Junagadh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);  //binding first comment

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //spinner = findViewById(R.id.spinnerbar);

        View view = binding.getRoot();
        setContentView(view);


        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,city);
        binding.spinnerbar.setAdapter(arrayAdapter);


        binding.spinnerbar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}