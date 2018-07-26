package com.capgemini.challenges.game;


public class GameEntity {

    private long gameId;

    private String name;

    public GameEntity(String name) {
        this.name = name;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
