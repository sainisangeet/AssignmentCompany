package com.example.sangeeth.assignment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangeeth on 21/2/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DatabaseVersion = 1;
    private static final String DatabaseName = "ListValue";
    private static final String TableName = "tabledata";


    /**
     *  attributes of the table name tabledata
     * @param context
     * @param name
     * @param factory
     * @param version
     */

    private static final String ID = "id";
    private static final String Name = "name";
    private static final String Mobile = "mobile";

    public DataBaseHandler(Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
    }

    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

     //   String Create_Table = "create table " + TableName + " ( " + Name + " TEXT," + Mobile + " TEXT " + ")";
        String Create_Table = "create table tabledata ( name text , mobile text )";
     //   Log.i("Create_Table ",Create_Table);
        db.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues =new ContentValues();


        contentValues.put(Name,contacts.getName());
        contentValues.put(Mobile,contacts.getMobile());
   //     Log.v("name and mobile ",contentValues.size() + "    " + contacts.getMobile());
        long result = db.insert(TableName,null,contentValues);
        db.close();
        return result;
    }


    public List<Contacts> getalldata() {
        List<Contacts> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TableName, null);
        if (res.moveToFirst()){
            while (res.moveToNext()!=res.isLast()) {
                Contacts contacts = new Contacts();
                contacts.setName(res.getString(0));
                contacts.setMobile(res.getString(1));
          //      Log.e("name " ,res.getString(0));
                contactList.add(contacts);
            }
        }
        return contactList;
    }


}
