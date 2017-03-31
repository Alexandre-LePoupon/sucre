package com.workshop.sucre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Asus on 31/03/2017.
 */

public class ProtocoleDAO extends DAOBase{
    public static final String TABLE_NAME = "Protocole";
    public static final String KEY = "id";
    public static final String LENT = "lent";
    public static final String RAPIDE = "rapide";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LENT + " REAL, " +
                    RAPIDE + " REAL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public ProtocoleDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param p le protocole à ajouter à la base
     */
    public void ajouter(Protocole p) {
        ContentValues value = new ContentValues();
        value.put(ProtocoleDAO.LENT, p.getLent());
        value.put(ProtocoleDAO.RAPIDE, p.getRapide());
        mDb.insert(ProtocoleDAO.TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du protocole à supprimer
     */
    public void supprimer(long id) {
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param p le protocole modifié
     */
    public void modifier(Protocole p) {
        ContentValues value = new ContentValues();
        value.put(LENT, p.getLent());
        value.put(RAPIDE, p.getRapide());
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(p.getId())});
    }

    /**
     * @param id l'identifiant du protocole à récupérer
     */
    public Protocole selectionner(long id) {
        float lent=0;
        float rapide=0;
        Cursor c = mDb.rawQuery("select " + LENT + "," + RAPIDE + " from " + TABLE_NAME + " where id = ?", new String[] {String.valueOf(id)});
        while (c.moveToNext()) {
            lent = c.getFloat(0);
            rapide = c.getFloat(1);
        }
        c.close();
        Protocole p = new Protocole(id, lent, rapide);
        return p;
    }
}
