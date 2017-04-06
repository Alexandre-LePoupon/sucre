package com.workshop.sucre.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Asus on 05/04/2017.
 */

public class ProduitDAO extends DAOBase{
    public static final String TABLE_NAME = "Produit";
    public static final String KEY = "id";
    public static final String NOM = "nom";
    public static final String CATEGORIE = "categorie";
    public static final String GLUCIDE = "glucide";
    public static final String SUCRE = "sucre";
    public static final String IMG = "img";
    public static final String QUANTITE = "QUANTITE";
    public static final String FASTFOOD = "fastfood";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOM + " TEXT, " +
                    CATEGORIE + " INTEGER, " +
                    GLUCIDE + " REAL, " +
                    SUCRE + " REAL, " +
                    IMG + "TEXT," +
                    QUANTITE + " REAL" +
                    FASTFOOD + "INTEGER);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public ProduitDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param p le produit à ajouter à la base
     */
    public void ajouter(Produit p) {
        ContentValues value = new ContentValues();
        value.put(ProduitDAO.NOM, p.getNom());
        value.put(ProduitDAO.CATEGORIE, p.getCategorie());
        value.put(ProduitDAO.GLUCIDE, p.getGlucide());
        value.put(ProduitDAO.SUCRE, p.getSucre());
        value.put(ProduitDAO.IMG, p.getImg());
        value.put(ProduitDAO.QUANTITE,p.getQuantite());
        value.put(ProduitDAO.FASTFOOD,p.getFastfood());
        mDb.insert(ProduitDAO.TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du produit à supprimer
     */
    public void supprimer(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param p le produit modifié
     */
    public void modifier(Produit p) {
        ContentValues value = new ContentValues();
        value.put(NOM, p.getNom());
        value.put(CATEGORIE, p.getCategorie());
        value.put(GLUCIDE, p.getGlucide());
        value.put(SUCRE, p.getSucre());
        value.put(IMG, p.getImg());
        value.put(QUANTITE,p.getQuantite());
        value.put(FASTFOOD,p.getFastfood());
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(p.getId())});
    }

    /**
     * retourne nombre de produit global
     */
    public long getSize() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = mDb.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    /**
     * @param id l'identifiant des produits à récupérer
     */
    public Produit selectionner(long id) {
        String nom="";
        int categorie=0;
        float glucide=0;
        float sucre=0;
        float quantite=0;
        int fastfood=0;
        String img="";
        Cursor c = mDb.rawQuery("select " + NOM + "," + CATEGORIE + "," + GLUCIDE + "," + SUCRE + "," + IMG + "," + QUANTITE + "," + FASTFOOD + " from " + TABLE_NAME + " where id = ?", new String[] {String.valueOf(id)});
        while (c.moveToNext()) {
            nom = c.getString(0);
            categorie = c.getInt(1);
            glucide = c.getFloat(2);
            sucre = c.getFloat(3);
            img = c.getString(4);
            quantite = c.getFloat(5);
            fastfood = c.getInt(6);
        }

        Produit p;
        if(nom == "" && categorie ==0 && glucide == 0 && sucre == 0 && img == "" && quantite == 0 && fastfood == 0) {
            p=null;
        } else {
            p = new Produit(id, nom, categorie, glucide, sucre, img, quantite, fastfood);
        }
        c.close();
        return p;
    }

    /**
     * @param categorie la catégorie des produits à récupérer
     */
    public Produit selectionnerCategorie(long id, int categorie) {
        String nom="";
        float glucide=0;
        float sucre=0;
        float quantite=0;
        int fastfood=0;
        String img="";
        Cursor c = mDb.rawQuery("select " + NOM + "," + GLUCIDE + "," + SUCRE + "," + IMG + "," + QUANTITE + "," + FASTFOOD + " from " + TABLE_NAME + " where id = ? and categorie = ?", new String[] {String.valueOf(id),String.valueOf(categorie)});
        while (c.moveToNext()) {
            nom = c.getString(0);
            glucide = c.getFloat(1);
            sucre = c.getFloat(2);
            img = c.getString(3);
            quantite = c.getFloat(4);
            fastfood = c.getInt(5);
        }

        Produit p;
        if(nom == "" && glucide == 0 && sucre == 0 && img == "" && quantite == 0 && fastfood == 0) {
            p=null;
        } else {
            p = new Produit(id, nom, categorie, glucide, sucre, img, quantite, fastfood);
        }
        c.close();
        return p;
    }
}
