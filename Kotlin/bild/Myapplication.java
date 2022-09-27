package com.example.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;

public class Myapplication extends Application {

    @Override
    public void onCreate() {
        Realm.init(this);

        RealmConfiguration realmConfiguration=new RealmConfiguration.Builder()
                .name("tops.db")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

        super.onCreate();
    }
}
