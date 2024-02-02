package com.joosal.restapi;

import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    private Words currentWord;
    private Set<Character> guessedLetters = new HashSet<>();
    private int remainingGuesses = 10;
    private String currentMaskedWord;

    public HangmanGame(Words word) {
        this.currentWord = word;
    }

    public boolean guessLetter(char letter) {
        guessedLetters.add(letter);
        boolean isCorrect = currentWord.getWord().toLowerCase().contains(String.valueOf(letter).toLowerCase());
        if (isCorrect) {
            updateMaskedWord();
        } else {
            remainingGuesses--;
        }
        return isCorrect;
    }

    private void updateMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (char letter : currentWord.getWord().toCharArray()) {
            if (guessedLetters.contains(Character.toLowerCase(letter))) {
                maskedWord.append(letter);
            } else {
                maskedWord.append('_');
            }
        }
        this.currentMaskedWord = maskedWord.toString();
    }

    public String getCurrentMaskedWord() {
        return this.currentMaskedWord;
    }

    public void setCurrentMaskedWord(String currentMaskedWord) {
        this.currentMaskedWord = currentMaskedWord;
    }

    public Words getCurrentWord() {
        return this.currentWord;
    }

    public void setCurrentWord(Words currentWord) {
        this.currentWord = currentWord;
    }

    public Set<Character> getGuessedLetters() {
        return this.guessedLetters;
    }

    public void setGuessedLetters(Set<Character> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    public int getRemainingGuesses() {
        return this.remainingGuesses;
    }

    public void setRemainingGuesses(int remainingGuesses) {
        this.remainingGuesses = remainingGuesses;
    }
}
