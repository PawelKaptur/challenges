package com.capgemini.challenges.player.dto;

import com.capgemini.challenges.game.GameEntity;

import java.util.List;

public class PlayerDTO {

    private long playerId;
    private String username;
    private int score;
    private List<GameEntity> listOfOwnedGames;

    public PlayerDTO() {
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

    public List<GameEntity> getListOfOwnedGames() {
        return listOfOwnedGames;
    }

    public void setListOfOwnedGames(List<GameEntity> listOfOwnedGames) {
        this.listOfOwnedGames = listOfOwnedGames;
    }
}
