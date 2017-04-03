package com.workshop.sucre;

/**
 * Created by Damien on 02/04/2017.
 */

public class FastFoodBDD {
    private long id;
    private String nom;

    public FastFoodBDD(long id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
