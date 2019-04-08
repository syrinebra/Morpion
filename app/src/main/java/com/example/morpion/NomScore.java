package com.example.morpion;

import java.io.Serializable;

public class NomScore implements Serializable {
    private String nom;
    private Integer scoreMax;

    public NomScore(String nom, Integer scoreMax){

        this.nom=nom;
        this.scoreMax=scoreMax;

    }
    public String getNom(){
        return nom;
    }
    public void setNom(){
        this.nom=nom;
    }
    public Integer getScoreMax(){
        return scoreMax;
    }
    public void setScoreMax(){
        this.scoreMax=scoreMax;
    }
}
