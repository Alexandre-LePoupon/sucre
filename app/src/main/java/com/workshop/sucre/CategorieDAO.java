package com.workshop.sucre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Damien on 02/04/2017.
 */

public class CategorieDAO extends DAOBase{
    public static final String TABLE_NAME = "Categorie";
    public static final String KEY = "id";
    public static final String NOM = "nom";
    public static final String TYPE = "type";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOM + " CHARACTER, " +
                    TYPE + " CHARACTER);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public CategorieDAO(Context pContext) { super(pContext); }


    public void ajouter(Categorie p) {
        ContentValues value = new ContentValues();
        value.put(CategorieDAO.NOM, p.getNom());
        value.put(CategorieDAO.TYPE, p.getType());
        mDb.insert(ProtocoleDAO.TABLE_NAME, null, value);
    }

    public void supprimer(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifier(Categorie p) {
        ContentValues value = new ContentValues();
        value.put(NOM, p.getNom());
        value.put(TYPE, p.getType());
        mDb.update(TABLE_NAME, value, KEY + " = ?", new String[] {String.valueOf(p.getId())});
    }


    public Categorie selectionner(long id) {
        String nom = null;
        String type = null;
        Cursor c = mDb.rawQuery("select " + NOM + "," + TYPE + " from " + TABLE_NAME + " where id = ?", new String[] {String.valueOf(id)});
        c.close();
        Categorie p = new Categorie(id, nom, type);
        return p;
    }
}
