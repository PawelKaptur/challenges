package com.capgemini.challenges.challenge.dto;

import java.util.Date;

public class ChallengeDTO {

    private long challengeId;

    private long thrownBy;
    private long gameId;
    private boolean isGameIsEnd;
    private Date dateOfChallenge;
    private String invitationMessage;

    public ChallengeDTO() {

    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public void setThrownBy(long thrownBy) {
        this.thrownBy = thrownBy;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setGameIsEnd(boolean gameIsEnd) {
        this.isGameIsEnd = gameIsEnd;
    }

    public void setDateOfChallenge(Date dateOfChallenge) {
        this.dateOfChallenge = dateOfChallenge;
    }

    public void setInvitationMessage(String invitationMessage) {
        this.invitationMessage = invitationMessage;
    }

    public long getChallengeId() {
        return challengeId;
    }

    public long getThrownBy() {
        return thrownBy;
    }

    public long getGameId() {
        return gameId;
    }

    public boolean isGameIsEnd() {
        return isGameIsEnd;
    }

    public Date getDateOfChallenge() {
        return dateOfChallenge;
    }

    public String getInvitationMessage() {
        return invitationMessage;
    }
}
