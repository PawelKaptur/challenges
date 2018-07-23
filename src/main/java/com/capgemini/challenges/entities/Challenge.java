package com.capgemini.challenges.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Challenge {

    @Id
    @GeneratedValue
    private long challgeneId;

    private Player playerOne;
    private Player playerTwo;

    private Game game;

    private boolean statusPlayerOne;
    private boolean statusPlayerTwo;

    private boolean gameStatus;

    private Date dateOfChallenge;

    public Challenge(Player playerOne, Player playerTwo, Game game, boolean statusPlayerOne, boolean statusPlayerTwo, boolean gameStatus, Date dateOfChallenge) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.game = game;
        this.statusPlayerOne = statusPlayerOne;
        this.statusPlayerTwo = statusPlayerTwo;
        this.gameStatus = gameStatus;
        this.dateOfChallenge = dateOfChallenge;
    }

    public long getChallgeneId() {
        return challgeneId;
    }

    public void setChallgeneId(long challgeneId) {
        this.challgeneId = challgeneId;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isStatusPlayerOne() {
        return statusPlayerOne;
    }

    public void setStatusPlayerOne(boolean statusPlayerOne) {
        this.statusPlayerOne = statusPlayerOne;
    }

    public boolean isStatusPlayerTwo() {
        return statusPlayerTwo;
    }

    public void setStatusPlayerTwo(boolean statusPlayerTwo) {
        this.statusPlayerTwo = statusPlayerTwo;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Date getDateOfChallenge() {
        return dateOfChallenge;
    }

    public void setDateOfChallenge(Date dateOfChallenge) {
        this.dateOfChallenge = dateOfChallenge;
    }
}
