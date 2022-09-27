package com.example.realm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterFactory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    List<Model>list;
    Realm realm;
    Button bu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=findViewById(R.id.listview);
        list=new ArrayList<>();
        realm=Realm.getInstance(Realm.getDefaultConfiguration());
        bu1=findViewById(R.id.bu1);

        realm.beginTransaction();

        RealmResults<Model> results=realm.where(Model.class).findAll();
        for (Model m:results)
        {
            list.add(m);
        }
        realm.commitTransaction();
        Adapter adapter = new Adapter(getApplicationContext(),list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Select operations?");
                alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        AlertDialog.Builder alert2=new AlertDialog.Builder(MainActivity2.this);
                        LayoutInflater in= LayoutInflater.from(MainActivity2.this);
                        View view1 = in.inflate(R.layout.upadate,null);

                        EditText edt1=view1.findViewById(R.id.tu1);
                        EditText edt2=view1.findViewById(R.id.tu2);
                        Button btn1=view1.findViewById(R.id.bu1);
                        realm.beginTransaction();

                        edt1.setText(list.get(position).name);
                        edt2.setText(list.get(position).number);

                        realm.commitTransaction();
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                realm.beginTransaction();
                                RealmResults<Model> results1=realm.where(Model.class).findAll();

                                String n=edt1.getText().toString();
                                String p=edt2.getText().toString();

                                results1.get(position).setName(n);
                                results1.get(position).setNumber(p);

                                Intent i = new Intent(MainActivity2.this,MainActivity2.class);
                                startActivity(i);

                                realm.commitTransaction();
                            }
                        });
                        alert2.setView(view1);
                        alert2.show();
                    }
                });
                alert.setNegativeButton("Delet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        realm.beginTransaction();
                        RealmResults<Model> results1=realm.where(Model.class).findAll();
                        results1.deleteFromRealm(position);
                        realm.commitTransaction();

                        Intent i = new Intent(MainActivity2.this,MainActivity2.class);
                        startActivity(i);

                    }
                });
                alert.show();
            }
        });
    }
}