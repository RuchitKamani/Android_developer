package com.example.sqlite_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyView> {

    Context context;
    List<ContactModel> list;

    public Adapter(Context context, List<ContactModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater in = LayoutInflater.from(context);
        View view = in.inflate(R.layout.design,parent,false);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyView holder, int position) {

        holder.txt1.setText(list.get(position).name);
        holder.txt2.setText(list.get(position).phone_no);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyView extends RecyclerView.ViewHolder {

        TextView txt1,txt2;


        public MyView(@NonNull View itemView) {
            super(itemView);

            txt1=itemView.findViewById(R.id.name1);
            txt2=itemView.findViewById(R.id.num1);
        }
    }
}
