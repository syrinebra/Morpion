package com.example.morpion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AccesLocal {



    private String nomBase="joueurs_database.db";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase mDB;

    private static final String TABLE_JOUEURS="table_joueurs";
    public static final String COL_SCORE="score";
    public static final String COL_NAME="nom";
    private static final String CREATE_DB =
            "create table " + TABLE_JOUEURS + " ("
                    + COL_SCORE + " integer primary key autoincrement, "
                    + COL_NAME + " text not null);";


    public AccesLocal(Context contexte){
        accesBD=new MySQLiteOpenHelper(contexte, nomBase, null, versionBase);
    }
    public void open(){
        //on ouvre la BDD en écriture
        mDB = accesBD.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        mDB.close();
    }

    public NomScore getNomScore(Integer score) throws SQLException {
        NomScore ns=null;
        Cursor c=  mDB.query(TABLE_JOUEURS,new String[]{COL_NAME, COL_SCORE},COL_SCORE+"="+score,null, null, null, null);
if (c.getCount()>0){
    c.moveToFirst();
    ns=new NomScore(c.getString(0),c.getInt(1));
}c.close();
return ns;
    }
    public List<NomScore> getAllJoueur(){
        List<NomScore> joueurs=new ArrayList<NomScore>();
        Cursor c=mDB.query(TABLE_JOUEURS,new String[]{COL_NAME, COL_SCORE},null,null,null,null,null);
    c.moveToFirst();
    while (!c.isAfterLast()){
        joueurs.add(new NomScore(
                c.getString(0),c.getInt(1)));
    c.close();}
    return joueurs;
    }
    public long insertJoueur(String nom,Integer score){
        ContentValues values=new ContentValues();
        values.put(COL_NAME,nom);
        values.put(COL_SCORE,score);
        return  mDB.insert(TABLE_JOUEURS,null,values);

    }
    public int updateClient(String nom,Integer score) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, nom);
        values.put(COL_SCORE, score);
        return mDB.update(TABLE_JOUEURS, values, COL_NAME + "=" + nom, null);
    }
    public int removeClient(String nom) {
        return mDB.delete(TABLE_JOUEURS, COL_NAME + " = " + nom, null);
    }

}
