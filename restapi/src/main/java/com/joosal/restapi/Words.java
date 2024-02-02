package com.joosal.restapi;

import java.util.HashSet;
import java.util.Set;

public class Words {
    private int id;
    private String word;
    private int amountOfCharacters;
    private int uniqueLetterCount;

    public Words(int id, String word) {
        this.id = id;
        this.word = word;
        this.amountOfCharacters = word.length();
        this.uniqueLetterCount = calculateUniqueLetterCount(word);
    }

    private int calculateUniqueLetterCount(String input) {
        Set<Character> uniqueLetters = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueLetters.add(Character.toLowerCase(c));
        }
        return uniqueLetters.size();
    }

    public int getId() {
        return this.id;
    }

    public int getUniqueLetterCount() {
        return this.uniqueLetterCount;
    }

    public void setUniqueLetterCount(int uniqueLetterCount) {
        this.uniqueLetterCount = uniqueLetterCount;
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

}
