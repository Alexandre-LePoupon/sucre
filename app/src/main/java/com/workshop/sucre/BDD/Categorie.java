package com.workshop.sucre.BDD;

/**
 * Created by Damien on 02/04/2017.
 */

public class Categorie {
    private long id;
    private String nom;
    private int type;
    private String img;

    public Categorie(long id, String nom, int type, String img) {
        this.id = id;
        this.nom = nom;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
