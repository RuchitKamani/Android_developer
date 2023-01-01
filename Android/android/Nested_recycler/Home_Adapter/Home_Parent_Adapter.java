package com.example.unique_fest_i_techno_peac.Business_package.Home_Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unique_fest_i_techno_peac.Business_package.Home_Model.Home_Parent_Model;
import com.example.unique_fest_i_techno_peac.R;

import java.util.List;

public class Home_Parent_Adapter extends RecyclerView.Adapter<Home_Parent_Adapter.MYviewPARENT> {

    Context context;
    List<Home_Parent_Model> home_parent_model_list;

    public Home_Parent_Adapter(Context context, int simple_list_item_1, List<Home_Parent_Model> home_parent_model_list) {
        this.context = context;
        this.home_parent_model_list = home_parent_model_list;
    }

    @NonNull
    @Override
    public Home_Parent_Adapter.MYviewPARENT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_perent_design, parent, false);

        return new MYviewPARENT(view);
    }


    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull Home_Parent_Adapter.MYviewPARENT holder, int position) {
        holder.txt.setText(home_parent_model_list.get(position).getTxt_PARENT());

        Home_Chaild_Adapter home_chaild_adapter;
        home_chaild_adapter = new Home_Chaild_Adapter(context, home_parent_model_list.get(position).getHome_chaild_models());
        holder.recyclerViewPARENT.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerViewPARENT.setAdapter(home_chaild_adapter);

    }


    @Override
    public int getItemCount() {
        return home_parent_model_list.size();
    }

    public class MYviewPARENT extends RecyclerView.ViewHolder {

        TextView txt;
        RecyclerView recyclerViewPARENT;

        public MYviewPARENT(@NonNull View itemView) {
            super(itemView);


            txt = itemView.findViewById(R.id.txtPERENT);
            recyclerViewPARENT = itemView.findViewById(R.id.recyclerPERENT);

        }
    }
}
