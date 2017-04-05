package com.workshop.sucre.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Asus on 31/03/2017.
 */

public abstract class DAOBase {
    protected final static int VERSION = 1;
    protected final static String NOM = "database.db";

    protected SQLiteDatabase mDb = null;
    protected DatabaseHandler mHandler = null;

    public DAOBase(Context pContext) {
        this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);
       // this.open();
    }

    public SQLiteDatabase open() {

        mDb = mHandler.getWritableDatabase();
        //mHandler.onUpgrade(mDb,1,2);
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}
