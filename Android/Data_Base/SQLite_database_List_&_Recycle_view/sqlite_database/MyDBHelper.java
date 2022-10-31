package com.example.sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ram";
    private static final String TABLE_CONTACT = "contact";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";

    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*db.execSQL("CREATE TABLE " + TABLE_CONTACT +
                "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + "TEXT," + KEY_PHONE_NO + "TEXT" + ")");*/
        String query= "create table " + TABLE_CONTACT + " (" +KEY_ID +
                " integer primary key autoincrement, " +KEY_NAME+" text, "+KEY_PHONE_NO+ " text )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


       /* db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);
        onCreate(db);*/

        String upquery="drop table if exists "+TABLE_CONTACT;
        db.execSQL(upquery);
    }

    public long Insert(ContactModel m)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME,m.name);
        values.put(KEY_PHONE_NO,m.phone_no);

        return db.insert(TABLE_CONTACT,KEY_ID,values);

    }



    public List<ContactModel> viewdata(){

        List<ContactModel> list  = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String col[]={KEY_ID,KEY_NAME,KEY_PHONE_NO};
        Cursor cursor=db.query(TABLE_CONTACT,col,null,null,null,null,null);

        //Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_CONTACT,null);  // * all colums

        while (cursor.moveToNext()){


            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String phone=cursor.getString(2);

            ContactModel  m= new ContactModel();
            m.setId(id);
            m.setName(name);
            m.setPhone_no(phone);
            list.add(m);
        }
        return  list;
    }
    public void delete(int id)
    {

        SQLiteDatabase db=getWritableDatabase();
        String deletequery=KEY_ID+"="+id;
        db.delete(TABLE_CONTACT,deletequery,null);

    }
    public void Update(ContactModel m)
    {

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID,m.getId());
        values.put(KEY_NAME,m.getName());
        values.put(KEY_PHONE_NO,m.getPhone_no());
        String wherequery=KEY_ID+"="+m.getId();
        db.update(TABLE_CONTACT,values,wherequery,null);
    }
}
