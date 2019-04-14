package com.example.morpion;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    private String scoretxt; //score
    private String nomtxt; //nom
    private DBManager DBM;
    private ListView listViewScore;
    private JoueurArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView) findViewById(R.id.list);

        DBM = new DBManager(this);
        scoretxt = "";
        nomtxt = "";
        Intent intent = getIntent();
        if (intent != null) {
            scoretxt = intent.getStringExtra("scoretxt");
            nomtxt = intent.getStringExtra("nomtxt");
            System.out.println("Syrine");
            System.out.println("syrine");
        }
        listViewScore = findViewById(R.id.list);
        Cursor data = DBM.getListContents();
        addData(nomtxt, scoretxt);
        ArrayList<joueur> list = new ArrayList<>();

        if (data.getCount() != 0) {
            while (data.moveToNext()) {
                list.add(new joueur(data.getString(1), data.getString(2)));

                ArrayAdapter<joueur> itemsAdapter =

                        adapter = new JoueurArrayAdapter(List.this , list);

                listViewScore.setAdapter(adapter); } } }
                
    public void addData (String nom, String score) {

        boolean insertData = DBM.addData(nom, score);

        if (insertData) {

            System.out.println("SUCCES : AJOUTER");
        } else {

            System.out.println("ECHEC : AJOUTER");
        }

    }}
