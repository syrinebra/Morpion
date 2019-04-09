package com.example.morpion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
private static final String DATABASE_Name="Game.db";
private static final int DATABASE_VERSION=1;


    public DBManager( Context context) {

        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqltable="create table Joueur(score INT NOT NULL PRIMARY KEY, nom TEXT NOT NULL)";
        db.execSQL(sqltable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists "+DATABASE_Name);
    }

    public Cursor Afficher(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from  "+DATABASE_Name, null);
   return cursor; }
}
