package com.capgemini.challenges.player;

import com.capgemini.challenges.game.Game;

import java.util.List;

public class Player {

    private long playerId;
    private static long lastPlayerId = -1;

    private String username;
    private int score;

    //dodac jeszcze ability time, moze jako osobna klasa

    //to nie wiem czy dobrze
    private List<Game> listOfOwnedGames;

    public Player(String username) {
        this.playerId = ++lastPlayerId;
        this.username = username;
        this.score = 0;
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Game> getListOfOwnedGames() {
        return listOfOwnedGames;
    }

    public void setListOfOwnedGames(List<Game> listOfOwnedGames) {
        this.listOfOwnedGames = listOfOwnedGames;
    }
}
