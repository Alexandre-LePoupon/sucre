package com.workshop.sucre;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Damien on 02/04/2017.
 */

public class MenuDAO extends DAOBase{
    public static final String TABLE_NAME = "Menu";
    public static final String KEY = "id";
    public static final String NOM = "nom";
    public static final String TAILLE = "taille";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOM + " CHARACTER, " +
                    TAILLE + " CHARACTER);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public MenuDAO(Context pContext) { super(pContext); }


    public void ajouter(Menu p) {
        ContentValues value = new ContentValues();
        value.put (MenuDAO.NOM, p.getNom());
        value.put (MenuDAO.TAILLE, p.getTaille());
        mDb.insert(ProtocoleDAO.TABLE_NAME, null, value);
    }

    public void supprimer(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifier(Menu p) {
        ContentValues value = new ContentValues();
        value.put(NOM, p.getNom());
        value.put(TAILLE, p.getTaille());
        mDb.update(TABLE_NAME, value, KEY + " = ?", new String[] {String.valueOf(p.getId())});
    }


    public Menu selectionner(long id) {
        char nom=0;
        char taille=0;
        Cursor c = mDb.rawQuery("select " + NOM + "," + TAILLE + " from " + TABLE_NAME + " where id = ?", new String[] {String.valueOf(id)});
        c.close();
        Menu p = new Menu(id, nom, taille);
        return p;
    }
}
