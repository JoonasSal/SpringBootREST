package com.joosal.restapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyRestController {

    private final HangmanService hangmanService;

    public MyRestController(HangmanService hangmanService) {
        this.hangmanService = hangmanService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getGameInstructions() {
        String instructions = """
            Welcome to Hangman REST API Game!

            Instructions:

            Words for the game:
            1. Add words by sending a POST request to 'http://localhost:8080/words'. Words can be added as a raw plain text.
            2. You can check added words by sending a GET request to '/words'


            Playing the game:
            1. Start a new game by sending a POST request to '/start
            2. Guess a letter by sending it as a POST request to '/guess'. Character can be sent as a raw plain text.
            
            """;
        return ResponseEntity.ok(instructions);
    }

    @PostMapping("/start")
    public ResponseEntity<String> startGame() {
        hangmanService.startNewGame();
        return ResponseEntity.ok("New game started");
    }

    @PostMapping("/guess")
    public ResponseEntity<String> guessLetter(@RequestBody String letter) {
        if (letter == null || letter.length() != 1) {
            return ResponseEntity.badRequest().body("Please provide a single letter.");
        }
        boolean correct = hangmanService.guessLetter(letter.charAt(0));
        HangmanGame game = hangmanService.getCurrentGame();
        if (correct) {
            return ResponseEntity.ok("Correct guess! " + game.getCurrentMaskedWord());
        } else {
            return ResponseEntity.ok("Wrong guess! " + game.getCurrentMaskedWord() + " Remaining guesses: "
                    + game.getRemainingGuesses());
        }
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


}
