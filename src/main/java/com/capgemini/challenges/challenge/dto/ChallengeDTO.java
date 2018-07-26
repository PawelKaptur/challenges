package com.capgemini.challenges.challenge.dto;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ChallengeDTO {

    private long challengeId;

    private long thrownBy;
    private long gameId;
    private boolean challengeStatus;
    private Date dateOfChallenge;
    private String invitationMessage;

    @Autowired
    public ChallengeDTO(long challengeId, long thrownBy, long gameId, boolean challengeStatus, Date dateOfChallenge, String invitationMessage) {
        this.challengeId = challengeId;
        this.thrownBy = thrownBy;
        this.gameId = gameId;
        this.challengeStatus = challengeStatus;
        this.dateOfChallenge = dateOfChallenge;
        this.invitationMessage = invitationMessage;
    }

    public ChallengeDTO(){

    }

    public long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public long getThrownBy() {
        return thrownBy;
    }

    public void setThrownBy(long thrownBy) {
        this.thrownBy = thrownBy;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public boolean isChallengeStatus() {
        return challengeStatus;
    }

    public void setChallengeStatus(boolean challengeStatus) {
        this.challengeStatus = challengeStatus;
    }

    public Date getDateOfChallenge() {
        return dateOfChallenge;
    }

    public void setDateOfChallenge(Date dateOfChallenge) {
        this.dateOfChallenge = dateOfChallenge;
    }

    public String getInvitationMessage() {
        return invitationMessage;
    }

    public void setInvitationMessage(String invitationMessage) {
        this.invitationMessage = invitationMessage;
    }
}
