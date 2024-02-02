package com.joosal.restapi;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class HangmanService {
    private Map<Integer, Words> words = new HashMap<>();
    private int nextId = 0;

    private Map<String, Player> players = new HashMap<>();

    // metodi arvattavan sanan lisäämiseksi
    public void addWord(String word) {
        Words newWord = new Words(nextId, word);
        words.put(nextId, newWord);
        nextId++;
    }

    // metodi arvattavan sanan hakemiseen id:llä
    public Words getWord(int id) {
        return words.get(id);
    }
    
    // tää palauttaa kaikki lisätyt sanat
    public Collection<Words> getAllWords() {
        return words.values();
    }
    
}
