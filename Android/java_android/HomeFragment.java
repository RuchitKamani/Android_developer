package com.a.myapplication.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.a.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    ListView listView;
    List<String> list;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home2, container, false);

        listView=view.findViewById(R.id.list);
        list=new ArrayList<>();


        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);



    return  view;
    }
}