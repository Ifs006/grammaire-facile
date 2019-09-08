package com.example.gramairefacile.database.entity;

public class Materi {
    // TABLE NAME
    public static final String TABLE_NAME = "tbl_materi";

    // TABLE COLUMN
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENTS = "contents";

    private int id;
    private int type;
    private String title;
    private String contents;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TYPE + " INTEGER,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_CONTENTS + " TEXT"
                    + ")";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return contents;
    }

    public void setContent(String contents) {
        this.contents = contents;
    }
}