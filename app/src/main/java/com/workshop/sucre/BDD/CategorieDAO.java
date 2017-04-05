package com.workshop.sucre.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Damien on 02/04/2017.
 */

public class CategorieDAO extends DAOBase {
    public static final String TABLE_NAME = "Categorie";
    public static final String KEY = "id";
    public static final String NOM = "nom";
    public static final String TYPE = "type";
    public static final String IMG = "img";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOM + " TEXT, " +
                    TYPE + " INTEGER, " +
                    IMG + " TEXT);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public CategorieDAO(Context pContext) { super(pContext); }


    public void ajouter(Categorie p) {
        ContentValues value = new ContentValues();
        value.put(CategorieDAO.NOM, p.getNom());
        value.put(CategorieDAO.TYPE, p.getType());
        value.put(CategorieDAO.IMG, p.getImg());
        mDb.insert(CategorieDAO.TABLE_NAME, null, value);
    }

    public void supprimer(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifier(Categorie p) {
        ContentValues value = new ContentValues();
        value.put(NOM, p.getNom());
        value.put(TYPE, p.getType());
        value.put(IMG, p.getImg());
        mDb.update(TABLE_NAME, value, KEY + " = ?", new String[] {String.valueOf(p.getId())});
    }


    public Categorie selectionner(long id) {
        String nom = "";
        int type = 0;
        String img = "";
        Cursor c = mDb.rawQuery("select " + NOM + "," + TYPE + "," + IMG + " from " + TABLE_NAME + " where id = ?", new String[] {String.valueOf(id)});

        while (c.moveToNext()) {
            nom = c.getString(0);
            type = c.getInt(1);
            img = c.getString(2);
        }

        Categorie p;
        if(nom == "" && type == 0 && img == "") {
            p=null;
        } else {
            p = new Categorie(id, nom, type, img);
        }

        c.close();
        return p;
    }
}
