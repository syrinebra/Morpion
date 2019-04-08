package com.example.morpion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private String creation="create table morp("+"nom STRING ,"+"score INTEGER NOT NULL);";

    public MySQLiteOpenHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//si changement de BD
    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(creation);
    }
//si changement de version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
