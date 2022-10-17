package com.example.menu_and_search_call;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.menu_and_search.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
        list= new ArrayList<>();
        searchView = findViewById(R.id.search);

         list.add("Android");
         list.add("Java");
         list.add("kotlin");
         list.add("python");
         list.add("Core Java");
         list.add("c++");


         ArrayAdapter arrayAdapter = new ArrayAdapter
                 (MainActivity.this, android.R.layout.simple_list_item_1,list);

         listView.setAdapter(arrayAdapter);

         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {


                 /*if (list.contains(query))
                 {
                     arrayAdapter.getFilter().filter(query);
                 }*/
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {

                 String suggestword  = getIntent().getDataString();
                 searchView.setQuery(suggestword,true);
                 searchView.clearFocus();
                 arrayAdapter.getFilter().filter(newText);

                 return false;
             }
         });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optiion,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.i1:
                Toast.makeText(this, "calling", Toast.LENGTH_SHORT).show();

                String num="9510675879";
                Intent i =new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+num));
                startActivity(i);


                break;
        }
        return super.onOptionsItemSelected(item);
    }
}