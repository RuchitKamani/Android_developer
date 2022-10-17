package com.example.s_cafe_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;


public class order_page extends AppCompatActivity {

    CheckBox che1, che2,che3,che4;
    RadioButton r1, r2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        che1 = findViewById(R.id.ch1);
        che2 = findViewById(R.id.ch2);
        che3 = findViewById(R.id.ch3);
        che4 = findViewById(R.id.ch4);
        r1 = findViewById(R.id.onlinepay);
        r2 = findViewById(R.id.casepay);
        btn1 = findViewById(R.id.order);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer buffer = new StringBuffer();
                buffer.append("Your Bill\n");
                int amount = 0;
                String pay = "Please Select Pay..";

                if (che1.isChecked()) {
                    amount += 130;
                    buffer.append("\nPizza : - 130");
                }
                if (che2.isChecked()) {
                    amount += 100;
                    buffer.append("\nFrench fries :- 100");
                }
                if (che3.isChecked()) {
                    amount += 50;
                    buffer.append("\nVeg sandwich : - 50");
                }
                if (che4.isChecked()) {
                    amount += 60;
                    buffer.append("\nAloo tikki : - 60");
                }
                if (r1.isChecked())
                {
                    pay = "online";
                    buffer.append("");
                }
                if (r2.isChecked())
                {
                    pay = "case";
                    buffer.append("");
                }


                buffer.append("\n\nTotal :- " + amount);
                buffer.append("\n\nPayment :- " + pay);

                Intent i = new Intent(order_page.this, Bill_Activity.class);
                i.putExtra("ruchit", buffer.toString()); //data pass
                startActivity(i);
            }
        });


    }
}