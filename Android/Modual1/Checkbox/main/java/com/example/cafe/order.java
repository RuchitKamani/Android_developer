package com.example.cafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class order extends AppCompatActivity {

    CheckBox ch1,ch2,ch3;
    ImageView im1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ch1=findViewById(R.id.ch1);
        ch2=findViewById(R.id.ch2);
        ch3=findViewById(R.id.ch3);
        im1=findViewById(R.id.im1);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer buffer = new StringBuffer();
                buffer.append("Your bill\n");
                int amount=0; //amount

                if (ch1.isChecked())
                {
                    amount+=50;
                    buffer.append("\n pizaa $50\n ");
                }
                if (ch2.isChecked())
                {
                    amount+=30;
                    buffer.append("\n Burger $30 \n");
                }
                if (ch3.isChecked())
                {
                    amount+=20;
                    buffer.append("\nCocacola $20\n");
                }
                buffer.append("\ntotal :-"+ amount);

                Toast.makeText(order.this, ""+buffer.toString(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(order.this,billprocess.class);
                i.putExtra("tops",buffer.toString());//data pass
                startActivity(i);
            }
        });



    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(order.this);
        alert.setTitle("are you sure? Exit page");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finishAffinity();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alert.show();
    }
}