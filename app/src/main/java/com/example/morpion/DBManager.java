package com.example.morpion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.content.ContentValues;
import java.util.Date;
import java.sql.SQLException;
public class DBManager extends SQLiteOpenHelper {


    private static final String DATABASE_Name = "Game.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "score_data";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_SCORE = "score";
    SQLiteDatabase db;




    public DBManager(Context context) {

        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

 /* String strSql = "create table score_data ("
               + " id integer primary key autoincrement,"
               + " name text not null,"
               + " score text not null,"
               + " when_ integer not null"
               + ")";
        db.execSQL(strSql);
        Log.i("DATABASE", "onCreate invoked");
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT " + COL_NAME + " TEXT " +
                COL_SCORE + " INTEGER " + ");";*/
String createTable = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NAME TEXT, "+
                "SCORE TEXT)";

    db.execSQL(createTable);
        Log.i("DATABASE", "onCreate invoked");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String strSql="alter table T_Score add colu...";
       String strSql="drop table score_data";
        db.execSQL(strSql);
        this.onCreate(db);
        Log.i("DATABASE", "onUpgrade invoked");
     /*   String drop = "DROP IF TABLE EXISTS ";

        db.execSQL(drop+ TABLE_NAME);*/

    }
    public boolean  addData(String name, String score){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME , name);
        contentValues.put(COL_SCORE , score);
        long result = db.insert(TABLE_NAME , null , contentValues);

        if (result == -1){

            return false;
        }

        else {

            return true;
        }


    }
   public Cursor getListContents(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " +TABLE_NAME,null );

        return data;

    }

    /* public joueur getJoueur() throws SQLException {
        joueur j = null;
        Cursor c = db.query(TABLE_NAME,
                new String [] {COL_ID, COL_NAME, COL_SCORE},
                COL_ID + " = " + id, null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            j = new joueur(c.getInt(0), c.getString(1), c.getInt(2));
        }
        c.close();
        return j;
    }*/



    }
