package com.example.morpion;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;


public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    //Tablaeu a deux dimensions
    //plateau[colonne][ligne]
    //0:case vide
    //1: X
    //2:O
    private int plateau[][]=new int[3][3];
    //1: X
    //2:O
    private int joueurEnCours=1;
    private TextView tvJoueur;
     TextView tvScoreX;
     TextView tvScoreY;
     TextView txtwinner1;
    private int scoreX=0;
    private int scoreY=0;
    private int val=0;


    ArrayList<Button> all_buttons=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvJoueur=(TextView)findViewById(R.id.joueur);
        tvScoreX=(TextView)findViewById(R.id.gagnantX);
        tvScoreY=(TextView)findViewById(R.id.gagnantY);
        txtwinner1=(TextView)findViewById(R.id.txtwinner);
        Button bt1=(Button) findViewById(R.id.bt1);
        Button bt2=(Button) findViewById(R.id.bt2);
        Button bt3=(Button) findViewById(R.id.bt3);
        Button bt4=(Button) findViewById(R.id.bt4);
        Button bt5=(Button) findViewById(R.id.bt5);
        Button bt6=(Button) findViewById(R.id.bt6);
        Button bt7=(Button) findViewById(R.id.bt7);
        Button bt8=(Button) findViewById(R.id.bt8);
        Button bt9=(Button) findViewById(R.id.bt9);
        Button tryagain=(Button)findViewById(R.id.tryagain);
        all_buttons.add(bt1);
        all_buttons.add(bt2);
        all_buttons.add(bt3);
        all_buttons.add(bt4);
        all_buttons.add(bt5);
        all_buttons.add(bt6);
        all_buttons.add(bt7);
        all_buttons.add(bt8);
        all_buttons.add(bt9);
      all_buttons.add(tryagain);


        for(Button bt: all_buttons){
            bt.setBackgroundDrawable(null);
            bt.setOnClickListener(this);
        }

        tryagain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                resetGame();
                txtwinner1.setText("No one");
    }});



    }
    public  void Enregistrer(){

        Intent intent = new Intent(GameActivity.this, AutreActivity.class);

        if(scoreY>scoreX){
            String str="les Y ont gagnées avec un score :";
            intent.putExtra("score",scoreY);
            intent.putExtra("textView",str);}else{
            String str="les O ont gagnées avec un score :";
            intent.putExtra("textView",str);
            intent.putExtra("score",scoreX);
        }
        startActivity(intent);

    }
    public void onClick(View view) {
        if(view.getBackground()!=null)
            return;
        switch(view.getId()){
            case R.id.bt1:      //if(view.getId() == R.id.bt1)
                plateau[0][0]=joueurEnCours;
                break;
            case R.id.bt2:
                plateau[1][0]=joueurEnCours;
                break;
            case R.id.bt3:
                plateau[2][0]=joueurEnCours;
                break;
            case R.id.bt4:
                plateau[0][1]=joueurEnCours;
                break;
            case R.id.bt5:
                plateau[1][1]=joueurEnCours;
                break;
            case R.id.bt6:
                plateau[2][1]=joueurEnCours;
                break;
            case R.id.bt7:
                plateau[0][2]=joueurEnCours;
                break;
            case R.id.bt8:
                plateau[1][2]=joueurEnCours;
                break;
            case R.id.bt9:
                plateau[2][2]=joueurEnCours;
                break;
            case R.id.tryagain:
               resetGame();
                break;
        }

        Drawable drawableJoueur;
        if(joueurEnCours==1)
            drawableJoueur= ContextCompat.getDrawable(this, R.drawable.x);
        else
            drawableJoueur=ContextCompat.getDrawable(this, R.drawable.c);
        view.setBackgroundDrawable(drawableJoueur);


        if (joueurEnCours==1){
            joueurEnCours=2;
            tvJoueur.setText("O");

        }
        else{
            joueurEnCours=1;
            tvJoueur.setText("X");
        }

        int res=checkWinner();

     Score(res);
     Winner(res);


     displayAlertDialog(res);

 }




    //0: partie non fini
    //1 : X
    //2: O
    //3: egalite


    private int checkWinner() {

        // on regrade s'il y a un gagnant sur les colonnes

        for (int col = 0; col <= 2; col++) {
            if (plateau[col][0] != 0 && plateau[col][0] == plateau[col][1] && plateau[col][0] == plateau[col][2])
                return plateau[col][0];

        }

        // on regrade s'il y a un gagnant sur les lignes

        for (int line = 0; line <= 2; line++) {
            if (plateau[0][line] != 0 && plateau[0][line] == plateau[1][line] && plateau[0][line] == plateau[2][line])
                return plateau[0][line];

        }

        // on regrade s'il y a un gagnant sur la diagonale haut/gauche -> Bas/Droite

        if(plateau[0][0]!=0 && plateau[0][0]==plateau[1][1]&&plateau[0][0]==plateau[2][2])
            return  plateau[0][0];

        // on regrade s'il y a un gagnant sur la diagonale haut/droite -> Bas/gauche

        if(plateau[2][0]!=0 && plateau[2][0]==plateau[1][1]&&plateau[2][0]==plateau[0][2])
            return plateau[2][0];

        //Egalité

        boolean isPlateauPlein= true;
        for (int col = 0; col <= 2; col++) {
            for (int line = 0; line <= 2; line++) {
                if(plateau[col][line]==0){
                    isPlateauPlein=false;
                    break;
                }
            }
            if (!isPlateauPlein)
                break;
        }
        if(isPlateauPlein)
            return 3;

        //Partie non fini
        return 0;
    }
    private void Score(int res){
        if (res==0)
            return;
        tvScoreX.setText("");
        tvScoreY.setText("");
        if (res==1){
            scoreX++;
            tvScoreX.setText(""+scoreX);
            tvScoreY.setText(""+scoreY);
        }
        if (res==2){
            scoreY++;
            tvScoreX.setText(""+scoreX);
            tvScoreY.setText(""+scoreY);
        }
        if (res==3){
            tvScoreX.setText(""+scoreX);
            tvScoreY.setText(""+scoreY);}
    }

    private void Winner(int res){

        if(res==0)
            return;
        txtwinner1.setText("No Personne");

        if(res==1)

        { txtwinner1.setText("les X ont gagnées !");


        /*for (Button bt : all_buttons) {
                bt.setOnClickListener(null);
            }*/}


        if(res==2)

    {
        txtwinner1.setText("les O ont gagnées !");

    /* for (Button bt : all_buttons) {
            //bt.setBackgroundDrawable(null);
            bt.setOnClickListener(null);
        }*/ }


        if(res==3)
            txtwinner1.setText(" Egalité !");


    }


  private void displayAlertDialog(int res){

        if(res==0)
            return;
        String strTdDisplay="";


        if(res==1)
            strTdDisplay="les X ont gagnées !";

        if(res==2)
            strTdDisplay="les O ont gagnées !";

        if(res==3)
        strTdDisplay=" Egalité !";
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle(strTdDisplay);
      // alertDialog.setMessage(strTdDisplay);

        alertDialog.setNeutralButton("Recommencer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
                val++;

            }
        });

       if(val==3){
           displayAlertDialog1();
      }



        alertDialog.setCancelable(false);
        alertDialog.show();

    }
private void displayAlertDialog1(){

        AlertDialog.Builder alertDialog1=new AlertDialog.Builder(this);
        alertDialog1.setTitle("Fin de La Partie");
        alertDialog1.setMessage("Vous voulez enregistrer le meilleur Score?");

    alertDialog1.setNeutralButton("Enregistrer", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Enregistrer();
        }
    });

    alertDialog1.setCancelable(false);
    alertDialog1.show();


}

    private void resetGame(){
        for (int col = 0; col <= 2; col++) {
            for (int line = 0; line <= 2; line++) {
                plateau[col][line]=0;}}
        for(Button bt : all_buttons){
            bt.setBackgroundDrawable(null);

        }

    }


}
