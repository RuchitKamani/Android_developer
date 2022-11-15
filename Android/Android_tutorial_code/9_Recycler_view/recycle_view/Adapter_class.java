package com.example.recycle_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//1.extends RecyclerView.Adapter , <Adapter.Myview>
//2. alt + enter
public class Adapter_class extends RecyclerView.Adapter<Adapter_class.Myview> {//3


    //3
    Context context;
    List<Model_class> list;

    public Adapter_class(Context context, List<Model_class> list) {
        this.context = context;
        this.list = list;
    }


    //5
    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater in = LayoutInflater.from(context);
        View view = in.inflate(R.layout.design_recycle,parent,false);
        return new Myview(view);
    }

    //6
    @Override
    public void onBindViewHolder(@NonNull Adapter_class.Myview holder, int position) {

        holder.imga.setImageResource(list.get(position).img);
        holder.txta.setText(list.get(position).txt1);
        holder.txt1a.setText(list.get(position).txt2);

    }

    //7
    @Override
    public int getItemCount() {
        return list.size();

        //move to m.java
    }


    //4
    public class Myview extends RecyclerView.ViewHolder {
        ImageView imga;
        TextView txta,txt1a;

        public Myview(@NonNull View itemView) {
            super(itemView);

            imga=itemView.findViewById(R.id.img);
            txta=itemView.findViewById(R.id.txt1);
            txt1a=itemView.findViewById(R.id.txt2);



        }
    }
}
