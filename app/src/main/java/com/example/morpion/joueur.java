package com.example.morpion;

public class joueur {

    int score;
    String nom;
public joueur()
{
    super();
}    public  joueur(int score, String nom){
        super();
        this.score=score;
        this.nom=nom;
    }

    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }

}
