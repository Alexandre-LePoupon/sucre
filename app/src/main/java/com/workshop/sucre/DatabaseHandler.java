package com.workshop.sucre;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asus on 31/03/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String PROTOCOLE_KEY = "id";
    public static final String PROTOCOLE_LENT = "lent";
    public static final String PROTOCOLE_RAPIDE = "rapide";

    public static final String PROTOCOLE_TABLE_NAME = "Protocole";
    public static final String PROTOCOLE_TABLE_CREATE =
            "CREATE TABLE " + PROTOCOLE_TABLE_NAME + " (" +
                    PROTOCOLE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PROTOCOLE_LENT + " REAL, " +
                    PROTOCOLE_RAPIDE + " REAL);";
    public static final String PROTOCOLE_TABLE_DROP = "DROP TABLE IF EXISTS " + PROTOCOLE_TABLE_NAME + ";";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PROTOCOLE_TABLE_DROP);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PROTOCOLE_TABLE_CREATE);
    }
}
