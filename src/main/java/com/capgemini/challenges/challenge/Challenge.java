package com.capgemini.challenges.challenge;

import java.util.Date;
import java.util.List;


public class Challenge {

    private long challengeId;

    private List<Long> playersId;
    private long gameId;
    private List<UserStatus> statusesOfPlayers;
    private boolean gameStatus;
    private Date dateOfChallenge;

    public Challenge(long challengeId, List<Long> playersId, long gameId, List<UserStatus> statusesOfPlayers, boolean gameStatus, Date dateOfChallenge) {
        this.challengeId = challengeId;
        this.playersId = playersId;
        this.gameId = gameId;
        this.statusesOfPlayers = statusesOfPlayers;
        this.gameStatus = gameStatus;
        this.dateOfChallenge = dateOfChallenge;
    }

    public Challenge() {
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public long getChallengeId() {
        return challengeId;
    }

    public List<Long> getPlayersId() {
        return playersId;
    }

    public void setPlayersId(List<Long> playersId) {
        this.playersId = playersId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public List<UserStatus> getStatusesOfPlayers() {
        return statusesOfPlayers;
    }

    public void setStatusesOfPlayers(List<UserStatus> statusesOfPlayers) {
        this.statusesOfPlayers = statusesOfPlayers;
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
