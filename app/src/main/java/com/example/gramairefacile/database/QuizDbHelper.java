package com.example.gramairefacile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Gramairre_Facile.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
<<<<<<< HEAD
//        this.db = db;
//        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE" +
//                QuestionsTable.TABLE_NAME + " ( " +
//
=======
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE";
//                QuestionsTable.TABLE_NAME + " ( " +

>>>>>>> a482fe608a74d621742e7a15f0a8753d5f56af8f
    }
//
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
    }
<<<<<<< HEAD
//
//    private void fillQuestionsTable() {
//
//
//    }
//
=======

    private void fillQuestionsTable() {


    }

>>>>>>> a482fe608a74d621742e7a15f0a8753d5f56af8f
//    private void addQuestion(Question question) {
//
//
//    }
//
//    public List<Question> getAllQuestions() {
//
//
//        c.close();
//        return questionList;
//    }


}
