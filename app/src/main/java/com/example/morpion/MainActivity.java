package com.example.morpion;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    //Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   myDialog = new Dialog(this);


    }

    public void Start(View v) {
        TextView txtclose;
        Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
        startActivity(gameActivity);
       /* myDialog.setContentView(R.layout.activity_main);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    */}


}
