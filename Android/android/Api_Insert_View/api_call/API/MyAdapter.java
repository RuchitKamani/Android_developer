package com.example.api_call.API;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_call.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {

    Context context;
    List<Model> dataList;
    Apiinterface api;

    public MyAdapter(Context context, List<Model> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyView holder, int position) {
        holder.t1.setText(dataList.get(position).getName());
        holder.t2.setText(dataList.get(position).getEmail());
        holder.t3.setText(dataList.get(position).getPassword());
        holder.t4.setText(dataList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
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
