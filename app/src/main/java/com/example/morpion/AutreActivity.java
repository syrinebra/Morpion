package com.example.morpion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AutreActivity extends AppCompatActivity {

    private TextView scor;
    private TextView scor1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre);
        scor=(TextView)findViewById(R.id.sco);
        scor1=(TextView)findViewById(R.id.sco1);
        Intent intent=getIntent();


        if(intent!=null){
            String str="";
            if(intent.hasExtra("textView")){
                scor1.setText(intent.getStringExtra("textView"));
            }

         scor.setText(""+intent.getIntExtra("score",0));
        }
    }
}
