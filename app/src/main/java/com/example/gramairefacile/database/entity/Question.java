package com.example.gramairefacile.database.entity;

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

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public int getCorrectIndexofChoices() {
        return correctIndexofChoices;
    }

    public void setCorrectIndexofChoices(int correctIndexofChoices) {
        this.correctIndexofChoices = correctIndexofChoices;
    }
}
