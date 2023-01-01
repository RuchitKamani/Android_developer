package com.example.unique_fest_i_techno_peac.Business_package.Home_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unique_fest_i_techno_peac.Business_package.Fregment_first.Custom_Fragment;
import com.example.unique_fest_i_techno_peac.Business_package.Home_Model.Api_Model;
import com.example.unique_fest_i_techno_peac.Business_package.View_all_activity_Recycler;
import com.example.unique_fest_i_techno_peac.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Home_Chaild_Adapter extends RecyclerView.Adapter<Home_Chaild_Adapter.MyviewChild> {
  Context context;
  List<Api_Model> home_chaild_modelList;

    public Home_Chaild_Adapter(Context context, List<Api_Model> home_chaild_modelList) {
        this.context = context;
        this.home_chaild_modelList = home_chaild_modelList;
    }

    @NonNull
    @Override
    public Home_Chaild_Adapter.MyviewChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater in = LayoutInflater.from(context);
        View view = in.inflate(R.layout.home_chaild_design,parent,false);
        return new MyviewChild(view);

    }


    @Override
    public void onBindViewHolder(@NonNull Home_Chaild_Adapter.MyviewChild holder, int position) {

        final Api_Model Data_position = home_chaild_modelList.get(position);

       // holder.imageView.setImageResource(home_chaild_modelList.get(position).getImg_CHAILD());
        Picasso.get().load(home_chaild_modelList.get(position).getImage()).into(holder.imageView);

       /* holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = new Intent(v.getContext(), View_all_activity_Recycler.class);
                in.putExtra("MyPost", Data_position.getImage());
                v.getContext().startActivity(in);

                *//*Intent intent = new Intent(context,Custom_Fragment.class);
                v.getContext().startActivity(intent);*//*
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return home_chaild_modelList.size();
    }

    public class MyviewChild extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyviewChild(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageCHAILD);
            
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(imageView.getContext(), "agasdg", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(context,View_all_activity_Recycler.class);
                    context.startActivity(i);
                }
            });

        }
    }
}
