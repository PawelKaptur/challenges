package com.capgemini.challenges.challenge;

import java.util.Date;

public class ChallengeEntity {

    private long challengeId;

    private Long thrownBy;
    private long gameId;
    private Boolean isGameIsEnd;
    private Date dateOfChallenge;
    private String invitationMessage;

    public ChallengeEntity(long challengeId, long thrownBy, long gameId, boolean isGameIsEnd, Date dateOfChallenge, String invitationMessage) {
        this.challengeId = challengeId;
        this.thrownBy = thrownBy;
        this.gameId = gameId;
        this.isGameIsEnd = isGameIsEnd;
        this.dateOfChallenge = dateOfChallenge;
        this.invitationMessage = invitationMessage;
    }

    public ChallengeEntity() {
    }

    public long getThrownBy() {
        return thrownBy;
    }

    public void setThrownBy(long thrownBy) {
        this.thrownBy = thrownBy;
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public long getChallengeId() {
        return challengeId;
    }

    public boolean isGameIsEnd() {
        return isGameIsEnd;
    }

    public void setGameIsEnd(boolean gameIsEnd) {
        this.isGameIsEnd = gameIsEnd;
    }

    public String getInvitationMessage() {
        return invitationMessage;
    }

    public void setInvitationMessage(String invitationMessage) {
        this.invitationMessage = invitationMessage;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public Date getDateOfChallenge() {
        return dateOfChallenge;
    }

    public void setDateOfChallenge(Date dateOfChallenge) {
        this.dateOfChallenge = dateOfChallenge;
    }
}
