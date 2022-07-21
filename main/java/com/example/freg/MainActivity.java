package com.example.freg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.freg.fragment.About_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linear=findViewById(R.id.linear);
        bottomNavigationView=findViewById(R.id.bottom);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.manu1:
                        Intent i = new Intent(MainActivity.this, About_Fragment.class);
                        startActivity(i);
                        break;

                    case R.id.menu2:
                        Toast.makeText(MainActivity.this, "mane2", Toast.LENGTH_SHORT).show();
                         break;

                    case R.id.menu3:
                        Toast.makeText(MainActivity.this, "menu3", Toast.LENGTH_SHORT).show();
                        break;
                }
               transaction.commit();

                return true;
            }
        });

                /*Fragmentine f1 = new Fragmentine();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linear,f1);
                transaction.commit();*/


    }
}