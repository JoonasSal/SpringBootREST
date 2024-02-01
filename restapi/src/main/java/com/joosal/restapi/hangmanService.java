package com.joosal.restapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class hangmanService {
    private Map<Integer, Words> words = new HashMap<>();
    private Map<String, Player> players = new HashMap<>();

    // metodi arvattavan sanan lisäämiseksi
    public void addWord(Words word) {
        words.put(word.getId(), word);
    }

    // metodi arvattavan sanan hakemiseen id:llä
    public Words getWord(int id) {
        return words.get(id);
    }
    
    public Collection<Words> getAllWords() {
        return words.values();
    }
    
}
