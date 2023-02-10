package com.example.api_call.API;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_call.R;
import com.example.api_call.image_model;

import java.util.List;

public class MyAdapter_list extends RecyclerView.Adapter<MyAdapter_list.MyView> {

    Context context;
    List<Model> list1;
    Apiinterface api;



    public MyAdapter_list(Context context, List<Model> list1) {
        this.context = context;
        this.list1 = list1;
    }


    @NonNull
    @Override
    public MyAdapter_list.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter_list.MyView holder, int position) {
        holder.t1.setText(list1.get(position).getName());
        holder.t2.setText(list1.get(position).getEmail());
        holder.t3.setText(list1.get(position).getPassword());
        holder.t4.setText(list1.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        TextView t1, t2,t3,t4;
        public MyView(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
            t3=itemView.findViewById(R.id.txt3);
            t4=itemView.findViewById(R.id.txt4);
        }
    }
}
