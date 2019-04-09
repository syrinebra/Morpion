package com.example.morpion;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class AutreActivity extends GameActivity  {

    private TextView scor;
    private TextView scor1;
    private EditText txt;
    private Button bcreation;
    UserManager um;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre);

        bcreation=(Button)findViewById(R.id.bcreation);
        scor=(TextView)findViewById(R.id.sco);
        txt=(EditText)findViewById(R.id.plain_text_input);
        scor1=(TextView)findViewById(R.id.sco1);

        um=new UserManager(this);

        Intent intent=getIntent();
        if(intent!=null){
            String str="";
            if(intent.hasExtra("textView")){
                scor1.setText(intent.getStringExtra("textView"));
            }

            scor.setText(""+intent.getIntExtra("score",0));
        }

        bcreation.setOnClickListener(this);



    }


        public void onClick(View v) {
            um.open();
            joueur j=new joueur();
            int score=Integer.parseInt(scor.getText().toString());
            String nom=txt.getText().toString();
            j.setScore(score);
            j.setNom(nom);
            Long lg=um.AddJoueur(j);
            um.close();
            Toast.makeText(getApplicationContext() , "ligne a été ajouté", Toast.LENGTH_SHORT).show();

        }

}
