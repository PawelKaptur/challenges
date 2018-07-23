package com.capgemini.challenges.player.dto;

import com.capgemini.challenges.game.Game;

import java.util.List;

public class PlayerDTO {

    private long playerId;

    private String username;
    private int score;

    //dodac jeszcze ability time

    //to nie wiem czy dobrze
    private List<Game> listOfOwnedGames;

    public PlayerDTO(String username) {
        this.username = username;
        this.score = 0;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
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
