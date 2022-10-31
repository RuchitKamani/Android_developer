package com.example.sqlite_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class List_Adapter extends BaseAdapter {

    Context context;
    List<ContactModel> list;

    List_Adapter(Context context,List<ContactModel>list)
    {
        this.context=context;
        this.list=list;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater in=LayoutInflater.from(context);
        view=in.inflate(R.layout.design,viewGroup,false);


        TextView txt1=view.findViewById(R.id.name1);
        TextView txt2=view.findViewById(R.id.num1);

        txt1.setText(list.get(i).name);
        txt2.setText(list.get(i).phone_no);

        return view;

    }
}
