package com.workshop.sucre.BDD;

/**
 * Created by Damien on 02/04/2017.
 */

public class FastFoodBDD {
    private long id;
    private String nom;
    private String img;

    public FastFoodBDD(long id, String nom, String img){
        this.id = id;
        this.nom = nom;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
