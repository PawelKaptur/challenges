package com.capgemini.challenges.challenge.dto;

import java.util.Date;

public class ChallengeDTO {

    private long challengeId;

    private Long thrownBy;
    private long gameId;
    private Boolean isGameIsEnd;
    private Date dateOfChallenge;
    private String invitationMessage;

    public ChallengeDTO() {

    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public void setThrownBy(Long thrownBy) {
        this.thrownBy = thrownBy;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setGameIsEnd(Boolean gameIsEnd) {
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

    public Long getThrownBy() {
        return thrownBy;
    }

    public long getGameId() {
        return gameId;
    }

    public Boolean isGameIsEnd() {
        return isGameIsEnd;
    }

    public Date getDateOfChallenge() {
        return dateOfChallenge;
    }

    public String getInvitationMessage() {
        return invitationMessage;
    }
}
