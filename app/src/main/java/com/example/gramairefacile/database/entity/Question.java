package com.example.gramairefacile.database.entity;

import java.util.List;

public class Question {

    private String question;
    private String[] choices;
    private int correctIndexofChoices;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String[] getChoices() {
        return choices;
    }
    public int getCorrectIndexofChoices() {
        return correctIndexofChoices;
    }

    public void setCorrectIndexofChoices(int correctIndexofChoices) {
        this.correctIndexofChoices = correctIndexofChoices;
    }
}
