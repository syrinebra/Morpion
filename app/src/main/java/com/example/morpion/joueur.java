package com.example.morpion;

public class joueur {
    int id;
    String score;
    String nom;
public joueur()
{
    super();
}    public  joueur( String nom, String score){
        super();
        this.id=id;
        this.score=score;
        this.nom=nom;
    }
    public int getId(){ return id;}
    public String getScore(){
        return score;
    }

    public String getNom(){
        return nom;
    }


}
