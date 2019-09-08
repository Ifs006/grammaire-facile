package com.example.gramairefacile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.entity.Materi;
import com.example.gramairefacile.database.entity.Question;
import com.example.gramairefacile.database.entity.Quiz;
import com.example.gramairefacile.database.model.LesAdjectif;
import com.example.gramairefacile.database.model.LesArticles;
import com.example.gramairefacile.database.model.LesPronom;
import com.example.gramairefacile.database.model.LesVerbes;
import com.example.gramairefacile.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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
    public static final <T> T toArray(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    public static <T> List<T> toQuestionList(String json) {
        Type listType = new TypeToken<List<Question>>() {}.getType();
        return gson.fromJson(json, listType);
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
        // create btn_quiz table
        db.execSQL(Quiz.CREATE_TABLE);

        generateMateri();
        generateQuiz();
    }


    private void generateMateri() {
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

    }

    private void generateQuiz(){
        List<Question> questions;
        Question question;

        /*******************************************************************************************
         *  ADD QUIZ 1
         *******************************************************************************************/
        // Create new list question
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("J’ …. (habiter) à Paris.");
        question.setChoices(new String[]{"a.\thabite", "b.\thabites", "c.\thabitez", "d.\thabitent"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);
        // Reset question to new class
        question = new Question();
        question.setQuestion("Nous …. (parler) de son travail.");
        question.setChoices(new String[]{"a.\tparle", "b.\tparles", "c.\tparlons", "d.\tparlez"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu …. (jouer) le football.");
        question.setChoices(new String[]{"a.\tjoue", "b.\tjoues", "c.\tjouons", "d.\tjouez"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Il …. (crier) tous les nuits.");
        question.setChoices(new String[]{"a.\tcrie", "b.\tcries", "c.\tcrions", "d.\tcriez"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous …. (danser) avec Marie.");
        question.setChoices(new String[]{"a.\tdanse", "b.\tdanses", "c.\tdansons", "d.\tdansez"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Ma mère …. (travailler) à l’université.");
        question.setChoices(new String[]{"a.\ttravaillent", "b.\ttravailles", "c.\ttravaillez", "d.\ttravaille"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Jacques …. (acheter) des œufs.");
        question.setChoices(new String[]{"a.\tachète", "b.\tachètes", "c.\tachetez", "d.\tachetons"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Erick et moi …. (regarder) la télé.");
        question.setChoices(new String[]{"a.\tregardez", "b.\tregarde", "c.\tregardons", "d.\tregardes"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Julien et Paul …. (parler) français avec Monsieur Dupont.");
        question.setChoices(new String[]{"a.\tparle", "b.\tparlez", "c.\tparlent", "d.\tparlons"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous …. (fermer) la porte.");
        question.setChoices(new String[]{"a.\tfermes", "b.\tfermez", "c.\tferment", "d.\tfermons"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(1, "Pilihlah konjugasi yang tepat dari kata kerja berakhiran -er di dalam kurung !", questions);

        /*******************************************************************************************
         *  ADD QUIZ 2
         *******************************************************************************************/
        // Reset questions to new class
        questions = new ArrayList<>();
        // Create new class
        question = new Question();
        question.setQuestion("Je …. (être) japonais.");
        question.setChoices(new String[]{"a.\tsuis", "b.\test", "c.\tsommes", "d.\tavez"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);
        // Reset question to new class
        question = new Question();
        question.setQuestion("Nous …. (avoir) des stylos.");
        question.setChoices(new String[]{"a.\tsommes", "b.\ta", "c.\tavons", "d.\tai"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Elle …. (faire) de la cuisine.");
        question.setChoices(new String[]{"a.\tfais", "b.\tfait", "c.\tfaisons", "d.\tfont"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        question = new Question();
        question.setQuestion("Vous .… (aller) à l’anniversaire de Paul.");
        question.setChoices(new String[]{"a.\tva", "b.\tvais", "c.\tallons", "d.\tallez"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Ils …. (être) professeurs de grammaire.");
        question.setChoices(new String[]{"a.\tsuis", "b.\tont", "c.\tsommes", "d.\tsont"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("J’…. (avoir) un portable.");
        question.setChoices(new String[]{"a.\tai", "b.\tavons", "c.\tas", "d.\ta"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Tu … (être) belle, Amanda.");
        question.setChoices(new String[]{"a.\tsuis", "b.\tont", "c.\tes", "d.\tas"});
        question.setCorrectIndexofChoices(2);
        questions.add(question);

        question = new Question();
        question.setQuestion("Michelle et moi …. (aller) à Paris aujourd’hui.");
        question.setChoices(new String[]{"a.\tallons", "b.\tva", "c.\tvais", "d.\tvont"});
        question.setCorrectIndexofChoices(0);
        questions.add(question);

        question = new Question();
        question.setQuestion("Mon père et ma mère …. (faire) de la cuisine.");
        question.setChoices(new String[]{"a.\tfais", "b.\tfait", "c.\tfaisons", "d.\tfont"});
        question.setCorrectIndexofChoices(3);
        questions.add(question);

        question = new Question();
        question.setQuestion("Suzane …. (avoir) deux enfants.");
        question.setChoices(new String[]{"a.\tas", "b.\ta", "c.\tont", "d.\tavons"});
        question.setCorrectIndexofChoices(1);
        questions.add(question);

        addNewQuiz(2, "Pilihlah konjugasi yang tepat dari kata kerja irrégulier di dalam kurung !", questions);
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

        Log.i("@MATERI", gson.toJson(contents));

        // insert row
        long id = db.insert(Materi.TABLE_NAME, null, values);
        // return newly inserted row id
        return id;
    }

    public long addNewQuiz(int idMateri, String title, List<Question> questions) {
        ContentValues values = new ContentValues();
        // `id` will be inserted automatically.
        // no need to add them
        values.put(Quiz.COLUMN_ID_MATERI, idMateri);
        values.put(Quiz.COLUMN_TITLE, title);
        values.put(Quiz.COLUMN_QUESTIONS, gson.toJson(questions));

        Log.i("@QUIZ", gson.toJson(questions));

        // insert row
        long id = db.insert(Quiz.TABLE_NAME, null, values);
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

    public Quiz getQuizByMateri(int idMateri){
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getWritableDatabase();

        String QUERY = "SELECT tbl_quiz.id, tbl_quiz.title_quiz, tbl_quiz.questions FROM tbl_quiz INNER JOIN tbl_materi ON tbl_quiz.id_materi= tbl_materi.id WHERE tbl_quiz.id_materi=?";

        Cursor cursor = db.rawQuery(QUERY, new String[]{String.valueOf(idMateri)});

        if (cursor != null)
            cursor.moveToFirst();

        // prepare quiz object
        Quiz quiz= new Quiz();
        quiz.setId(cursor.getInt(cursor.getColumnIndex(Quiz.COLUMN_ID)));
        quiz.setTitleQuiz(cursor.getString(cursor.getColumnIndex(Quiz.COLUMN_TITLE)));
        quiz.setQuestions(cursor.getString(cursor.getColumnIndex(Quiz.COLUMN_QUESTIONS)));

        // close the db connection
        cursor.close();

        return quiz;
    }
}
