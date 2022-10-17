package com.example.popup_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    Button btn1;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        txt1 = findViewById(R.id.txt1);
        layout = findViewById(R.id.layout);

        btn1.setOnClickListener(new View.OnClickListener() {// tap to butten show popup menu
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this,btn1);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.p1: // id of popup menu
                                Toast.makeText(MainActivity.this, "m1...", Toast.LENGTH_SHORT).show();

                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });//end btn1 click event..

       registerForContextMenu(txt1);  // context menu show for long press..
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.m1:
                Intent i = new Intent(MainActivity.this,About_activity.class);
                startActivity(i);
            case R.id.m2:
                finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context_menu,menu);
        menu.add(0, v.getId(), 0, "Yellow");
        menu.add(0, v.getId(), 0, "Gray");
        menu.add(0, v.getId(), 0, "Cyan");
        menu.add(0, v.getId(), 0, "White");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getTitle() == "Yellow") {
            layout.setBackgroundColor(Color.YELLOW);
        } else if (item.getTitle() == "Gray") {
            layout.setBackgroundColor(Color.GRAY);
        } else if (item.getTitle() == "Cyan") {
            layout.setBackgroundColor(Color.CYAN);
        }else if (item.getTitle() == "White") {
            layout.setBackgroundColor(Color.WHITE);
        }
        return super.onContextItemSelected(item);
    }
}