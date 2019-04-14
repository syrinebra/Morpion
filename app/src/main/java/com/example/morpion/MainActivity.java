package com.example.morpion;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    Button afficher;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        afficher = (Button) findViewById(R.id.btnAfich);

        dbManager= new DBManager(this);


    }
public void Restart(View v){
    Intent MyListActivity = new Intent(MainActivity.this, List.class);
    startActivity(MyListActivity);
}

    public void Start(View v) {
        TextView txtclose;
        Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
        startActivity(gameActivity);
    }
}