package com.example.gramairefacile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.entity.Materi;
import com.example.gramairefacile.database.entity.Quiz;
import com.example.gramairefacile.database.model.LesAdjectif;
import com.example.gramairefacile.database.model.LesArticles;
import com.example.gramairefacile.database.model.LesPronom;
import com.example.gramairefacile.database.model.LesVerbes;
import com.example.gramairefacile.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "grammairefacile_db";

    // Pretty print
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Convert JSON to Array
    public static int[] toArray(String json) {
        return gson.fromJson(json, int[].class);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        // create materi table
        db.execSQL(Materi.CREATE_TABLE);
        // create quiz table
        db.execSQL(Quiz.CREATE_TABLE);

        initData();
    }


    private void initData() {
        // GENERATE MATERI VERB
        addNewMateri(Constants.Materi.TYPE_VERB, "LE VERBE RÉGULIER", new int[]{R.drawable.verb1_content1});
        addNewMateri(Constants.Materi.TYPE_VERB, "LE VERBE IRRÉGULIER", new int[]{R.drawable.verb2_content1, R.drawable.verb2_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "LE CONDITIONNEL DE POLITESSE", new int[]{R.drawable.verb3_content1});
        addNewMateri(Constants.Materi.TYPE_VERB, "LA NÉGATION", new int[]{R.drawable.verb4_content1, R.drawable.verb4_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "LA FORME IMPERSONNELLE SIMPLE", new int[]{R.drawable.verb5_content1, R.drawable.verb5_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "L’IMPÉRATIF", new int[]{R.drawable.verb6_content1, R.drawable.verb6_content2});
        addNewMateri(Constants.Materi.TYPE_VERB, "LA PRÉSENT DE L’INDICATIF", new int[]{R.drawable.verb7_content1, R.drawable.verb7_content2, R.drawable.verb7_content3, R.drawable.verb7_content4});

        // GENERATE MATERI PRONOM
        addNewMateri(Constants.Materi.TYPE_PRONOM, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.pronom1_content1});
        addNewMateri(Constants.Materi.TYPE_PRONOM, "LES PRONOMS TONIQUES", new int[]{R.drawable.pronom2_content1, R.drawable.pronom2_content2});
        addNewMateri(Constants.Materi.TYPE_PRONOM, "LES INTÉROGATIFS SIMPLES", new int[]{R.drawable.pronom3_content1});

        // GENERATE MATERI ARTICLES
        addNewMateri(Constants.Materi.TYPE_ARTICLES, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.articles1_content1});
        addNewMateri(Constants.Materi.TYPE_ARTICLES, "LES PRONOMS TONIQUES", new int[]{R.drawable.articles2_content1});
        addNewMateri(Constants.Materi.TYPE_ARTICLES, "LES INTÉROGATIFS SIMPLES", new int[]{R.drawable.articles3_content1});

        // GENERATE MATERI ADJECTIF
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.adjectif1_content1, R.drawable.adjectif1_content2});
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "LES PRONOMS TONIQUES", new int[]{R.drawable.adjectif2_content1});
        addNewMateri(Constants.Materi.TYPE_ADJECTIF, "LES INTÉROGATIFS SIMPLES", new int[]{R.drawable.adjectif3_content1, R.drawable.adjectif3_content2});

        // GENERATE MATERI CONJONCTION
        addNewMateri(Constants.Materi.TYPE_CONJONCTION, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.conjonction1_content1, R.drawable.conjonction1_content2});

        // GENERATE MATERI INTERROGATION
        addNewMateri(Constants.Materi.TYPE_INTERROGATION, "LES PRONOMS PERSONNELS SUJETS", new int[]{R.drawable.interrogation1_content1, R.drawable.interrogation1_content2});



    }



    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Materi.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Quiz.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long addNewMateri(int type, String title, int[] contents) {
        ContentValues values = new ContentValues();
        // `id` will be inserted automatically.
        // no need to add them
        values.put(Materi.COLUMN_TYPE, type);
        values.put(Materi.COLUMN_TITLE, title);
        values.put(Materi.COLUMN_CONTENTS, gson.toJson(contents));

        Log.i("@@@", gson.toJson(contents));

        // insert row
        long id = db.insert(Materi.TABLE_NAME, null, values);
        // return newly inserted row id
        return id;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getMateriByType(Class<T> dataClass) {
        List<T> materies = new ArrayList<>();
        int type = 0;

        if (dataClass == LesAdjectif.class)
            type = Constants.Materi.TYPE_ADJECTIF;
        else if (dataClass == LesArticles.class)
            type = Constants.Materi.TYPE_ARTICLES;
        else if (dataClass == LesPronom.class)
            type = Constants.Materi.TYPE_PRONOM;
        else if (dataClass == LesVerbes.class)
            type = Constants.Materi.TYPE_VERB;

        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(Materi.TABLE_NAME,
                new String[]{Materi.COLUMN_ID, Materi.COLUMN_TYPE, Materi.COLUMN_TITLE, Materi.COLUMN_CONTENTS},
                Materi.COLUMN_TYPE + "=?",
                new String[]{String.valueOf(type)}, null, null, Materi.COLUMN_ID + " ASC", null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            if (dataClass == LesAdjectif.class) {
                do {
                    LesAdjectif adjectif = new LesAdjectif();
                    adjectif.setIcon(R.drawable.icon_lesadjectif);
                    adjectif.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    adjectif.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));

                    materies.add((T) adjectif);
                } while (cursor.moveToNext());
            } else if (dataClass == LesArticles.class) {
                do {
                    LesArticles articles = new LesArticles();
                    articles.setIcon(R.drawable.icon_lesarticles);
                    articles.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    articles.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    articles.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) articles);
                } while (cursor.moveToNext());
            } else if (dataClass == LesVerbes.class) {
                do {
                    LesVerbes verbes = new LesVerbes();
                    verbes.setIcon(R.drawable.icon_lesverbes);
                    verbes.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    verbes.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    verbes.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) verbes);
                } while (cursor.moveToNext());
            } else if (dataClass == LesPronom.class) {
                do {
                    LesPronom pronom = new LesPronom();
                    pronom.setIcon(R.drawable.icon_lespronom);
                    pronom.setId(cursor.getInt(cursor.getColumnIndex(Materi.COLUMN_ID)));
                    pronom.setTitle(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_TITLE)));
                    pronom.setContents(cursor.getString(cursor.getColumnIndex(Materi.COLUMN_CONTENTS)));
                    materies.add((T) pronom);
                } while (cursor.moveToNext());
            }
        }

        // close db connection
        db.close();

        // return list
        return materies;
    }
}
