package com.workshop.sucre;

/**
 * Created by Damien on 02/04/2017.
 */

public class Categorie {
    private long id;
    private char nom;
    private char type;

    public Categorie(long id, char nom, char type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getNom() {
        return nom;
    }

    public void setNom(char nom) {
        this.nom = nom;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
