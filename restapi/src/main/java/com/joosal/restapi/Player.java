package com.joosal.restapi;

public class Player {
    private String username;
    private int score;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player(String username, int score) {
        this.username = username;
        this.score = score;
    }
}