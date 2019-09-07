package com.example.gramairefacile.database.entity;

public class Quiz {
    // TABLE NAME
    public static final String TABLE_NAME = "tbl_quiz";

    // TABLE COLUMN
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_MATERI = "id_materi";
    public static final String COLUMN_TITLE = "title_quiz";
    public static final String COLUMN_QUESTIONS = "questions";

    private int id;
    private int idMateri;
    private String titleQuiz;
    private String questions;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_ID_MATERI + " INTEGER,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_QUESTIONS + " TEXT"
                    + ")";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMateri() {
        return idMateri;
    }

    public void setIdMateri(int idMateri) {
        this.idMateri = idMateri;
    }

    public String getTitleQuiz() {
        return titleQuiz;
    }

    public void setTitleQuiz(String titleQuiz) {
        this.titleQuiz = titleQuiz;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}