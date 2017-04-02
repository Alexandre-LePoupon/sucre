package com.workshop.sucre;

/**
 * Created by Damien on 02/04/2017.
 */

public class FastFoodBDD {
    private long id;
    private char nom;

    public FastFoodBDD(long id, char nom){
        this.id = id;
        this.nom = nom;
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
}
