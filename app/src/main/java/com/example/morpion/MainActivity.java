package com.example.morpion;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    Button afficher;
    DBManager dbManager;

    //Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        afficher = (Button) findViewById(R.id.btnAfich);


Affichage();

    }


    public void Start(View v) {
        TextView txtclose;
        Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
        startActivity(gameActivity);

    }

    void Affichage() {
        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = dbManager.Afficher();
                if (cur.getCount() == 0) {
                 display("List element","Pas d'elements");
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cur.moveToNext()) {
                        stringBuffer.append("Nom :" + cur.getString(0) + "\n");
                        stringBuffer.append("Score :" + cur.getInt(1) + "\n");
                        display("List element", stringBuffer.toString());
                    }
                }
            }
        });
    }

    void display(String titre, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titre);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
}