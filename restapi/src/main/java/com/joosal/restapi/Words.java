package com.joosal.restapi;

public class Words {
    private int id;
    private String word;
    private int amountOfCharacters;

    public Words(int id, String word, int amountOfCharacters) {
        this.id = id;
        this.word = word;
        this.amountOfCharacters = amountOfCharacters;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAmountOfCharacters() {
        return this.amountOfCharacters;
    }

    public void setAmountOfCharacters(int amountOfCharacters) {
        this.amountOfCharacters = amountOfCharacters;
    }

}
