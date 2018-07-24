package com.capgemini.challenges.challenge.dto;

import com.capgemini.challenges.game.Game;
import com.capgemini.challenges.player.Player;

import java.util.Date;

public class ChallengeDTO {

    private long challengeId;

    private long playerOneId;
    private long playerTwoId;

    private long gameId;

    private boolean statusPlayerOne;
    private boolean statusPlayerTwo;

    private boolean gameStatus;

    private Date dateOfChallenge;

    public ChallengeDTO(long challengeId, long playerOneId, long playerTwoId, long gameId, boolean statusPlayerOne, boolean statusPlayerTwo, boolean gameStatus, Date dateOfChallenge) {
        this.challengeId = challengeId;
        this.playerOneId = playerOneId;
        this.playerTwoId = playerTwoId;
        this.gameId = gameId;
        this.statusPlayerOne = statusPlayerOne;
        this.statusPlayerTwo = statusPlayerTwo;
        this.gameStatus = gameStatus;
        this.dateOfChallenge = dateOfChallenge;
    }

    public ChallengeDTO() {
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public long getChallengeId() {
        return challengeId;
    }

    public long getPlayerOneId() {
        return playerOneId;
    }

    public void setPlayerOneId(long playerOneId) {
        this.playerOneId = playerOneId;
    }

    public long getPlayerTwoId() {
        return playerTwoId;
    }

    public void setPlayerTwoId(long playerTwoId) {
        this.playerTwoId = playerTwoId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
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
