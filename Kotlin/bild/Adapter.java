package com.example.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    Context context;
    List<Model>list;


    Adapter(Context context,List list){

        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
         convertView = inflater.inflate(R.layout.degine,parent,false);

        TextView  t1=convertView.findViewById(R.id.t1);
        TextView t2=convertView.findViewById(R.id.t2);

        t1.setText(list.get(position).name);
        t2.setText(list.get(position).number);

        return convertView;
    }
}
