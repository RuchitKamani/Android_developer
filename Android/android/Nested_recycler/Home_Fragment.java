package com.example.unique_fest_i_techno_peac.Business_package.Fregment_first;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unique_fest_i_techno_peac.Business_package.Home_Adapter.Home_Parent_Adapter;
import com.example.unique_fest_i_techno_peac.Business_package.Home_Api.Api_client;
import com.example.unique_fest_i_techno_peac.Business_package.Home_Api.Api_interface;
import com.example.unique_fest_i_techno_peac.Business_package.Home_Model.Api_Model;
import com.example.unique_fest_i_techno_peac.Business_package.Home_Model.Home_Parent_Model;
import com.example.unique_fest_i_techno_peac.R;
import com.example.unique_fest_i_techno_peac.databinding.HomeFragmentBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home_Fragment extends Fragment {

    private HomeFragmentBinding binding;


    public List<Home_Parent_Model> parent_models_class_array_list;
    List<Api_Model> list1;
    List<Api_Model> list2;
    List<Api_Model> list3;
    List<Api_Model> list4;
    List<Api_Model> list5;
    List<Api_Model> list6;

    Api_interface apiinterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.home_fragment, container, false);

        binding = HomeFragmentBinding.inflate(inflater, container, false);

        parent_models_class_array_list = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();



        apiinterface = Api_client.getApiclient().create(Api_interface.class);

        Call<List<Api_Model>> call1 = apiinterface.imagetview();
        call1.enqueue(new Callback<List<Api_Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Api_Model>> call, @NonNull Response<List<Api_Model>> response) {


                list1 = response.body();
                parent_models_class_array_list.add(new Home_Parent_Model("List 1", list1));

                adapterclass();


            }
            @Override
            public void onFailure(@NonNull Call<List<Api_Model>> call, @NonNull Throwable t) {
            }
        });

        Call<List<Api_Model>> call2 = apiinterface.imagetview();
        call2.enqueue(new Callback<List<Api_Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Api_Model>> call, @NonNull Response<List<Api_Model>> response) {


                list2 = response.body();
                parent_models_class_array_list.add(new Home_Parent_Model("List 2", list2));
                adapterclass();
            }
            @Override
            public void onFailure(@NonNull Call<List<Api_Model>> call, @NonNull Throwable t) {
            }
        });

        Call<List<Api_Model>> call3 = apiinterface.imagetview();
        call3.enqueue(new Callback<List<Api_Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Api_Model>> call, @NonNull Response<List<Api_Model>> response) {


                list3 = response.body();
                parent_models_class_array_list.add(new Home_Parent_Model("List 3", list3));
                adapterclass();
            }
            @Override
            public void onFailure(@NonNull Call<List<Api_Model>> call, @NonNull Throwable t) {
            }
        });

        Call<List<Api_Model>> call4 = apiinterface.imagetview();
        call4.enqueue(new Callback<List<Api_Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Api_Model>> call, @NonNull Response<List<Api_Model>> response) {


                list4 = response.body();
                parent_models_class_array_list.add(new Home_Parent_Model("List 4", list4));
                adapterclass();
            }
            @Override
            public void onFailure(@NonNull Call<List<Api_Model>> call, @NonNull Throwable t) {
            }
        });

        Call<List<Api_Model>> call5 = apiinterface.imagetview();
        call5.enqueue(new Callback<List<Api_Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Api_Model>> call, @NonNull Response<List<Api_Model>> response) {


                list4 = response.body();
                parent_models_class_array_list.add(new Home_Parent_Model("List 4", list4));
                adapterclass();
            }
            @Override
            public void onFailure(@NonNull Call<List<Api_Model>> call, @NonNull Throwable t) {
            }
        });

        Call<List<Api_Model>> call6 = apiinterface.imagetview();
        call6.enqueue(new Callback<List<Api_Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Api_Model>> call, @NonNull Response<List<Api_Model>> response) {


                list4 = response.body();
                parent_models_class_array_list.add(new Home_Parent_Model("List 4", list4));
                adapterclass();
            }
            @Override
            public void onFailure(@NonNull Call<List<Api_Model>> call, @NonNull Throwable t) {
            }
        });


      /*  home_parent_adapter = new Home_Parent_Adapter(getContext(),parent_models_class_array_list);
        binding.recyclerTXT1.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerTXT1.setAdapter(home_parent_adapter);*/


        return binding.getRoot();


    }

    private void adapterclass() {
       /* Home_Parent_Adapter home_parent_adapter1 = new Home_Parent_Adapter(getContext(), android.R.layout.simple_list_item_1, parent_models_class_array_list);
        binding.recyclerTXT1.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerTXT1.setAdapter(home_parent_adapter1);*/

        Home_Parent_Adapter home_parent_adapter1 = new Home_Parent_Adapter(getContext(),
                android.R.layout.simple_expandable_list_item_1, Collections.synchronizedList(parent_models_class_array_list));
        binding.recyclerTXT1.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recyclerTXT1.setAdapter(home_parent_adapter1);
    }
}



      /*
           parent_models_class_array_list.add(new Home_Parent_Model("List2",list2));
        list2.add(new Home_Chaild_Model(R.drawable.setting));
        list2.add(new Home_Chaild_Model(R.drawable.setting));
        list2.add(new Home_Chaild_Model(R.drawable.setting));
        list2.add(new Home_Chaild_Model(R.drawable.setting));

      parent_models_class_array_list.add(new Home_Parent_Model("List3",list3));
        list3.add(new Home_Chaild_Model(R.drawable.custom));
        list3.add(new Home_Chaild_Model(R.drawable.custom));
        list3.add(new Home_Chaild_Model(R.drawable.custom));
        list3.add(new Home_Chaild_Model(R.drawable.custom));

        parent_models_class_array_list.add(new Home_Parent_Model("List4",list4));
        list4.add(new Home_Chaild_Model(R.drawable.resume));
        list4.add(new Home_Chaild_Model(R.drawable.resume));
        list4.add(new Home_Chaild_Model(R.drawable.resume));
        list4.add(new Home_Chaild_Model(R.drawable.resume));

        parent_models_class_array_list.add(new Home_Parent_Model("List5",list5));
        list5.add(new Home_Chaild_Model(R.drawable.two));
        list5.add(new Home_Chaild_Model(R.drawable.two));
        list5.add(new Home_Chaild_Model(R.drawable.two));
        list5.add(new Home_Chaild_Model(R.drawable.two));

        parent_models_class_array_list.add(new Home_Parent_Model("List6",list6));
        list6.add(new Home_Chaild_Model(R.drawable.download));
        list6.add(new Home_Chaild_Model(R.drawable.download));
        list6.add(new Home_Chaild_Model(R.drawable.download));
        list6.add(new Home_Chaild_Model(R.drawable.download));*/