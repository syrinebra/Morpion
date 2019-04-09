package com.example.morpion;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;

public class UserManager {

    DBManager dbm;
    SQLiteDatabase db;

    public UserManager(Context ctx)
    {

        dbm=new DBManager(ctx,"Game.db",null,1);
    }
public void open(){

        db=dbm.getWritableDatabase();
}
 public void close(){

        db.close();
 }
 public long AddJoueur(joueur j){

        ContentValues vals= new ContentValues();
             vals.put("score",j.getScore());
        vals.put("nom",j.getNom());
        return  db.insert("joueur",null,vals);
 }

}
