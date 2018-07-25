package com.capgemini.challenges.challenge;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class Challenge {

    private long challengeId;

    private Map<Long, UserStatus> userDecision;
    //private List<Long> playersId;
    private long gameId;
    //private List<UserStatus> statusesOfPlayers;
    private boolean gameStatus;
    private Date dateOfChallenge;

    public Challenge(long challengeId, Map<Long, UserStatus> userDecision, long gameId, boolean gameStatus, Date dateOfChallenge) {
        this.challengeId = challengeId;
        this.userDecision = userDecision;
        this.gameId = gameId;
        this.gameStatus = gameStatus;
        this.dateOfChallenge = dateOfChallenge;
    }

    public Challenge() {
    }

    public Map<Long, UserStatus> getUserDecision() {
        return userDecision;
    }

    public void setUserDecision(Map<Long, UserStatus> userDecision) {
        this.userDecision = userDecision;
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public long getChallengeId() {
        return challengeId;
    }


    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
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
