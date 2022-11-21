package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class TabLayout extends AppCompatActivity {


    com.google.android.material.tabs.TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);


        toolbar=findViewById(R.id.tool1);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view1);
        setupviewpager();

        tabLayout=findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);




    }

    private void setupviewpager()
    {
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        adapter.getfragment("Login",new Chat());
        adapter.getfragment("Sign Up",new Status());


        viewPager.setAdapter(adapter);
    }
}