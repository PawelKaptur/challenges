package com.capgemini.challenges.game;


public class Game {

    private long gameId;

    private String name;

    public Game(String name) {
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
