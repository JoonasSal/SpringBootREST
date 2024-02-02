package com.joosal.restapi;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class HangmanService {
    private Map<Integer, Words> words = new HashMap<>();
    private int nextId = 0;
    private Random random = new Random();
    private HangmanGame currentGame;

    // metodi arvattavan sanan lisäämiseksi
    public void addWord(String word) {
        Words newWord = new Words(nextId, word);
        words.put(nextId, newWord);
        nextId++;
    }

    // arvotaan sana
    public Words getRandomWord() {
        if (words.size() == 0)
            return null;
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    // metodi arvattavan sanan hakemiseen id:llä
    public Words getWord(int id) {
        return words.get(id);
    }

    // tää palauttaa kaikki lisätyt sanat
    public Collection<Words> getAllWords() {
        return words.values();
    }

    //aloitetaan peli ja arvotaan sana
    public void startNewGame() {
        Words word = getRandomWord();
        if (word != null) {
            currentGame = new HangmanGame(word);
        }
    }

    public boolean guessLetter(char letter) {
        if (currentGame != null) {
            return currentGame.guessLetter(letter);
        }
        return false;
    }

    public HangmanGame getCurrentGame() {
        return currentGame;
    }

}
