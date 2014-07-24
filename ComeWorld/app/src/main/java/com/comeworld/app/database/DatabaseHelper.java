package com.comeworld.app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.comeworld.app.model.Recette;

/**
 * Created by come on 24/06/14.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_EXADS";
    public static final int DB_VERSION = 1;

    /* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
    // CREATE TABLE
    public static final String CREATE_TABLE_CONTACTS = "CREATE TABLE " + Recette.FeedEntry.table + " (" +
            Recette.FeedEntry.name + " TEXT, " +
            Recette.FeedEntry.origin + " TEXT, " +
            Recette.FeedEntry.step + " TEXT " +
            ");";

    private static DatabaseHelper sInstance = null;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }
    /* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */

    public static DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context);
        }
        return sInstance;
    }

    public static DatabaseHelper getInstance() {
        return getInstance(null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + StatsCountryData.FeedEntry.TABLE_STATS_COUNTRY_DATA);
        onCreate(sqLiteDatabase);
    }
}