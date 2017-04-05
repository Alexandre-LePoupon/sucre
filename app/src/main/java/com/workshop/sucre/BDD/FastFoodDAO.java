package com.workshop.sucre.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Damien on 03/04/2017.
 */

public class FastFoodDAO extends DAOBase {
    public static final String TABLE_NAME = "Fastfood";
    public static final String KEY = "id";
    public static final String NOM = "nom";
    public static final String IMAGE = "img";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOM + " TEXT, " +
                    IMAGE + " TEXT";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public FastFoodDAO(Context pContext) { super(pContext); }

    public void ajouter(FastFoodBDD p) {
        ContentValues value = new ContentValues();
        value.put (FastFoodDAO.NOM, p.getNom());
        value.put (FastFoodDAO.IMAGE, p.getImg());
        mDb.insert(FastFoodDAO.TABLE_NAME, null, value);
    }

    public void supprimer(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifier(FastFoodBDD p) {
        ContentValues value = new ContentValues();
        value.put(NOM, p.getNom());
        value.put(IMAGE, p.getImg());
        mDb.update(TABLE_NAME, value, KEY + " = ?", new String[] {String.valueOf(p.getId())});
    }


    public FastFoodBDD selectionner(long id) {
        String nom = "";
        String img = "";
        Cursor c = mDb.rawQuery("select " + NOM + "," + IMAGE + " from " + TABLE_NAME + " where id = ?", new String[] {String.valueOf(id)});

        while (c.moveToNext()) {
            nom = c.getString(0);
            img = c.getString(1);
        }

        c.close();
        FastFoodBDD p;

        if(nom == "" && img == "") {
            p = null;
        } else {
            p = new FastFoodBDD(id, nom, img);
        }

        return p;



    }
}
