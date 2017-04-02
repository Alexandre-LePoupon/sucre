package com.workshop.sucre;

/**
 * Created by Damien on 02/04/2017.
 */

public class Menu {
    private long id;
    private char nom;
    private char taille;

    public Menu (long id, char nom, char taille){
        this.id = id;
        this.nom = nom;
        this.taille = taille;
    }

    public long getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public long getNom() {
        return nom;
    }

    public void setNom(char nom) {
        this.nom = nom;
    }

    public long getTaille() {
        return taille;
    }

    public void setTaille(char taille) {
        this.taille = taille;
    }
}
