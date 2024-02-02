package com.joosal.restapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyRestController {

    private final HangmanService hangmanService;

    @Autowired
    public MyRestController(HangmanService hangmanService) {
        this.hangmanService = hangmanService;
    }

    @PostMapping("/words")
    public ResponseEntity<String> addWord(@RequestBody String word) {
        hangmanService.addWord(word);
        return ResponseEntity.ok(word + " added successfully");
    }

    @GetMapping("/words")
    public ResponseEntity<List<Words>> getAllWords() {
        Collection<Words> words = hangmanService.getAllWords();
        return ResponseEntity.ok(new ArrayList<>(words));
    }

    @GetMapping("/")
    public String getHomepage() {
        System.out.println("get pyyntö juureen");
        return "Welcome to REST root";
    }

    @GetMapping("/user")
    public String user(@RequestParam String username) {
        return username;
    }

    @PostMapping("/user")
    public String addUser(@RequestParam String username) {

        System.out.println("Adding user " + username);
        return "Success";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id) {
        return id.toString();
    }

}
