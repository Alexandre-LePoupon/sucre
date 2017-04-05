package com.workshop.sucre.BDD;

/**
 * Created by Asus on 05/04/2017.
 */

public class Produit {
    private long id;
    private String nom;
    private int categorie;
    private float glucide;
    private float sucre;
    private float quantite;
    private String img;

    public Produit(long id, String nom, int categorie, float glucide, float sucre, String img, float quantite) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.glucide = glucide;
        this.sucre = sucre;
        this.img = img;
        this.quantite = quantite;
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

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public float getGlucide() {
        return glucide;
    }

    public void setGlucide(float glucide) {
        this.glucide = glucide;
    }

    public float getSucre() {
        return sucre;
    }

    public void setSucre(float sucre) {
        this.sucre = sucre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getQuantite(){return this.quantite;}
}
