package com.workshop.sucre;

/**
 * Created by Damien on 02/04/2017.
 */

public class Categorie {
    private long id;
    private String nom;
    private String type;

    public Categorie(long id, String nom, String type) {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
