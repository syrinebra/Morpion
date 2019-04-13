package com.example.morpion;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class AutreActivity extends GameActivity {

    private TextView scor;
    private TextView scor1;
    private EditText txt;
    private Button bcreation;
    private Button bView1;

    DBManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre);

        bcreation = (Button) findViewById(R.id.bcreation);
        scor = (TextView) findViewById(R.id.sco);
        txt = (EditText) findViewById(R.id.plain_text_input);
        scor1 = (TextView) findViewById(R.id.sco1);
        bView1=(Button) findViewById(R.id.bView);
        databaseManager=new DBManager(this);
        bView1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        final String scoretx=scor.getText().toString();
        final String txtt=txt.getText().toString();
        Intent intent1= new Intent(AutreActivity.this, List.class);
        intent1.putExtra("scoretxt",scoretx);
        intent1.putExtra("nomtxt",txtt);
         startActivity(intent1);
    }
});
        Intent intent = getIntent();
        if(intent!=null){
            if(intent.hasExtra("textView")){
                scor1.setText(intent.getStringExtra("textView"));
            }

              scor.setText(""+intent.getStringExtra("score"));
        }

        bcreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String newentry=txt.getText().toString();
             String newentry1=scor.getText().toString();
             if(txt.length()!=0){
                 AddData(newentry,newentry1);

                 txt.setText("");
             }else{
                 Toast.makeText(AutreActivity.this,"You must put something in the text Field!!",Toast.LENGTH_LONG).show();
             }
            }
        });



    }
public void AddData(String newentry,String newentry1){

        boolean insertData=databaseManager.addData(newentry,newentry1);
        if(insertData== true){
            Toast.makeText(AutreActivity.this,"Successfully entered!!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(AutreActivity.this,"Something went wrong!!",Toast.LENGTH_LONG).show();

        }

}

    }

