package com.example.i_techno_peak.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i_techno_peak.BuildConfig;
import com.example.i_techno_peak.MainActivity;
import com.example.i_techno_peak.R;
import com.example.i_techno_peak.Setting.ContactUs;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;


public class setting extends Fragment {

    TextView language, share, contact;
    TextView eng, guj, hindi,marathi,bangali,tamil,telugu,arabic;
    Locale myLocale;
    String currentLanguage = "en", currentLang;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        language = view.findViewById(R.id.language);
        share = view.findViewById(R.id.sharing);
        contact = view.findViewById(R.id.contact);


        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_design);

                eng = view.findViewById(R.id.eng_);
                guj = view.findViewById(R.id.guj_);
                hindi = view.findViewById(R.id.hin_);
                marathi = view.findViewById(R.id.marathi);
                bangali = view.findViewById(R.id.bangali);
                tamil = view.findViewById(R.id.tamil);
                telugu = view.findViewById(R.id.telugu);
                arabic = view.findViewById(R.id.arabic);



                TextView English = dialog.findViewById(R.id.eng_);
                TextView Gujarati = dialog.findViewById(R.id.guj_);
                TextView Hindi = dialog.findViewById(R.id.hin_);
                TextView marathi = dialog.findViewById(R.id.marathi);
                TextView bangali = dialog.findViewById(R.id.bangali);
                TextView tamil = dialog.findViewById(R.id.tamil);
                TextView telugu = dialog.findViewById(R.id.telugu);
                TextView arabic = dialog.findViewById(R.id.arabic);

               English.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("en");
                   }
               });
               Gujarati.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("gu");
                   }
               });
               Hindi.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("hi");
                   }
               });
               marathi.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("mr");
                   }
               });
               bangali.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("bn");
                   }
               });
               tamil.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("ta");
                   }
               });
               telugu.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("te");
                   }
               });
               arabic.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       setLocale("ar");
                   }
               });
                dialog.show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Share App", Snackbar.LENGTH_LONG).show();
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=com.radhikatech.biodata" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "please ", Toast.LENGTH_SHORT).show();

                }
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent i = new Intent(getActivity(), ContactUs.class);
            startActivity(i);




                /*try {
                    Snackbar.make(view, "Call", Snackbar.LENGTH_LONG).show();
                    String num = "9427445879";
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + num));
                    startActivity(i);
                } catch (Exception e) {
                    Snackbar.make(view, "Please Permission CALL PHONE", Snackbar.LENGTH_LONG).show();
                    //Toast.makeText(getActivity(), "Please Permission CALL PHONE", Toast.LENGTH_SHORT).show();
                }*/
              /*  Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:ruchitkamani1@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Request to Admin");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello sir");
                startActivity(intent);*/




            }
        });

        return view;


    }

    private void setLocale(String en) {
        try {
                myLocale = new Locale(en);
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(getActivity(), MainActivity.class);
                startActivity(refresh);

        }
        catch (Exception e){
            Toast.makeText(getContext(), "Language already selected!", Toast.LENGTH_SHORT).show();

        }
    }


}