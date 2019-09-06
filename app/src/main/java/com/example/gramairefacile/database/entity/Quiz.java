package com.example.gramairefacile.database.entity;

public class Quiz {
    // TABLE NAME
    public static final String TABLE_NAME = "tbl_submateri";

    // TABLE COLUMN
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_MATERI = "id_materi";
    public static final String COLUMN_TITLE = "title_submateri";
    public static final String COLUMN_CONTENT = "content";
    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT"
                    + ")";
    private int id;
    private String titleMateri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleMateri() {
        return titleMateri;
    }

    public void setTitleMateri(String titleMateri) {
        this.titleMateri = titleMateri;
    }
}