package com.workshop.sucre;

/**
 * Created by Asus on 31/03/2017.
 */

public class Protocole {
    private long id;
    private float lent;
    private float rapide;

    public Protocole(long id, float lent, float rapide) {
        this.id = id;
        this.lent = lent;
        this.rapide = rapide;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLent() {
        return lent;
    }

    public void setLent(float lent) {
        this.lent = lent;
    }

    public float getRapide() {
        return rapide;
    }

    public void setRapide(float rapide) {
        this.rapide = rapide;
    }
}
