package com.example.api_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.api_call.API.ApiClient;
import com.example.api_call.API.Apiinterface;
import com.example.api_call.API.Model;
import com.example.api_call.API.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Model> list;
    Apiinterface apiinterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();

        RecyclerView.LayoutManager rl =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rl);

        apiinterface = ApiClient.getapiclient().create(Apiinterface.class);
        Call<List<Model>> call  = apiinterface.productview();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                list = response.body();
                MyAdapter myAdapter =new MyAdapter(getApplicationContext(),list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

    }
}