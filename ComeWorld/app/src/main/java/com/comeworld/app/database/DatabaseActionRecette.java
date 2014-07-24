package com.comeworld.app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.comeworld.app.model.Recette;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by come on 24/06/14.
 */
public class DatabaseActionRecette {

    public static void addListCountryData(List<Recette> recetteList) {
        for (Recette recette : recetteList) {
            addRecette(recette);
        }
    }

    public static Long addRecette(Recette recette) {
        SQLiteDatabase db = DatabaseHelper.getInstance().getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Recette.FeedEntry.name, recette.getName());
        values.put(Recette.FeedEntry.origin, recette.getOrigin());
        values.put(Recette.FeedEntry.step, recette.getStep());

        Long e = db.insert(Recette.FeedEntry.table, null, values);
        db.close();
        return e;
    }

    public static List<Recette> getRecettes() {
        List<Recette> recetteList = new ArrayList<Recette>();
        String selectQuery = "SELECT * FROM " + Recette.FeedEntry.table;
        SQLiteDatabase db = DatabaseHelper.getInstance().getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Recette recette = new Recette();
                recette.setName(cursor.getString(0));
                recette.setOrigin(cursor.getString(1));
                recette.setStep(cursor.getString(2));
                recetteList.add(recette);
            }
            while (cursor.moveToNext());
        }
        return recetteList;
    }
}