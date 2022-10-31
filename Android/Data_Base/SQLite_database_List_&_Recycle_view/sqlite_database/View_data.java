package com.example.sqlite_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class View_data extends AppCompatActivity {

   //RecyclerView recyclerView;
   ListView listView;
    List<ContactModel> list;

    MyDBHelper myDBHelper;
    ArrayList<HashMap<String,String>>arrayList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        listView=findViewById(R.id.listview1);
        list= new ArrayList<>();
        myDBHelper=new MyDBHelper(getApplicationContext());

         list =myDBHelper.viewdata();

        for(ContactModel m:list)
        {
            HashMap map = new HashMap();
            map.put("id",m.getId());
            map.put("name",m.getName());
            map.put("number",m.getPhone_no());
            arrayList.add(map);

        }

        String from[]={"name","number"};
        int to[]={R.id.name1,R.id.num1};


        List_Adapter adapter = new List_Adapter(View_data.this,list);
        listView.setAdapter(adapter);
        /*RecyclerView.LayoutManager rl = new GridLayoutManager(View_data.this,1);
        recyclerView.setLayoutManager(rl);

        Adapter adapter =new Adapter(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
*/
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem m1= menu.add(0,1,0,"Upadate");
        MenuItem m2 = menu.add(0,2,0,"Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo acm = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id=acm.position;
        ContactModel m =list.get(id);

        switch (item.getItemId())
        {
            case 1:
                Intent i =new Intent(View_data.this,UpdateActivity.class);
                i.putExtra("id",m.getId());
                i.putExtra("name",m.getName());
                i.putExtra("number",m.getPhone_no());
                startActivity(i);

                break;

            case 2:
                AlertDialog.Builder alert =new AlertDialog.Builder(View_data.this);
                alert.setTitle("DELETE?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        myDBHelper.delete(m.getId());
                        startActivity(new Intent(View_data.this,View_data.class));

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();

                    }
                });
                alert.show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}