package com.workshop.sucre.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asus on 31/03/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Protocole
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

    //Fastfood
    public static final String FASTFOOD_KEY = "id";
    public static final String FASTFOOD_NOM = "nom";
    public static final String FASTFOOD_IMAGE = "img";
    public static final String FASTFOOD_TABLE_NAME = "Fastfood";
    public static final String FASTFOOD_TABLE_CREATE =
            "CREATE TABLE " + FASTFOOD_TABLE_NAME + " (" +
                    FASTFOOD_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FASTFOOD_NOM + " TEXT, " +
                    FASTFOOD_IMAGE + " TEXT);";
    public static final String FASTFOOD_TABLE_DROP = "DROP TABLE IF EXISTS " + FASTFOOD_TABLE_NAME + ";";

    //Categorie
    public static final String CATEGORIE_TABLE_NAME = "Categorie";
    public static final String CATEGORIE_KEY = "id";
    public static final String CATEGORIE_NOM = "nom";
    public static final String CATEGORIE_TYPE = "type";
    public static final String CATEGORIE_IMG = "img";

    public static final String CATEGORIE_TABLE_CREATE =
            "CREATE TABLE " + CATEGORIE_TABLE_NAME + " (" +
                    CATEGORIE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CATEGORIE_NOM + " TEXT, " +
                    CATEGORIE_TYPE + " INTEGER, " +
                    CATEGORIE_IMG + " TEXT);";

    public static final String CATEGORIE_TABLE_DROP = "DROP TABLE IF EXISTS " + CATEGORIE_TABLE_NAME + ";";

    //Produit
    public static final String PRODUIT_TABLE_NAME = "Produit";
    public static final String PRODUIT_KEY = "id";
    public static final String PRODUIT_NOM = "nom";
    public static final String PRODUIT_CATEGORIE = "categorie";
    public static final String PRODUIT_GLUCIDE = "glucide";
    public static final String PRODUIT_SUCRE = "sucre";
    public static final String PRODUIT_IMG = "img";
    public static final String PRODUIT_QUANTITE = "quantite";
    public static final String PRODUIT_FASTFOOD = "fastfood";

    public static final String PRODUIT_TABLE_CREATE =
            "CREATE TABLE " + PRODUIT_TABLE_NAME + " (" +
                    PRODUIT_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PRODUIT_NOM + " TEXT, " +
                    PRODUIT_CATEGORIE + " INTEGER, " +
                    PRODUIT_GLUCIDE + " REAL, " +
                    PRODUIT_SUCRE + " REAL, " +
                    PRODUIT_QUANTITE + " REAL, " +
                    PRODUIT_FASTFOOD + " INTEGER, " +
                    PRODUIT_IMG + " TEXT);";

    public static final String PRODUIT_TABLE_DROP = "DROP TABLE IF EXISTS " + PRODUIT_TABLE_NAME + ";";


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PROTOCOLE_TABLE_DROP);
        db.execSQL(FASTFOOD_TABLE_DROP);
        db.execSQL(PRODUIT_TABLE_DROP);
        db.execSQL(CATEGORIE_TABLE_DROP);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PROTOCOLE_TABLE_CREATE);
        db.execSQL(FASTFOOD_TABLE_CREATE);
        db.execSQL(CATEGORIE_TABLE_CREATE);
        db.execSQL(PRODUIT_TABLE_CREATE);
    }
}
