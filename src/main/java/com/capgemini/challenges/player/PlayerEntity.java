package com.capgemini.challenges.player;

import com.capgemini.challenges.game.GameEntity;

import java.util.List;

public class PlayerEntity {

    private long playerId;

    private String username;
    private int score;
    private List<GameEntity> listOfOwnedGames;

    public PlayerEntity(long playerId, String username, List<GameEntity> listOfOwnedGames) {
        this.playerId = playerId;
        this.username = username;
        this.score = 0;
        this.listOfOwnedGames = listOfOwnedGames;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
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

    public List<GameEntity> getListOfOwnedGames() {
        return listOfOwnedGames;
    }

    public void setListOfOwnedGames(List<GameEntity> listOfOwnedGames) {
        this.listOfOwnedGames = listOfOwnedGames;
    }
}
