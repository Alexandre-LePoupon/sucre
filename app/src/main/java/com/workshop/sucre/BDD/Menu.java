package com.workshop.sucre.BDD;

/**
 * Created by Damien on 02/04/2017.
 */

public class Menu {
    private long id;
    private String nom;
    private String taille;

    public Menu (long id, String nom, String taille){
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
}
