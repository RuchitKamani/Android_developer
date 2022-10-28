package com.example.adapter_show_data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {


    Context context;
    List<Modelclass> list;

    public Adapter(Context context, List<Modelclass> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.design_xml, viewGroup, false);

        ImageView image = view.findViewById(R.id.img);
        TextView tex = view.findViewById(R.id.txt);

        image.setImageResource(list.get(i).image);
        tex.setText(list.get(i).txt);


        return view;
    }
}
