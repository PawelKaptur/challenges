package com.capgemini.challenges.challenge;

import java.util.Date;
import java.util.Map;

public class ChallengeEntity {

    private long challengeId;

    private long thrownBy;
    private long gameId;
    private boolean challengeStatus;
    private Date dateOfChallenge;
    private String invitationMessage;

    //private Map<Long, UserStatus> userDecision;


    public ChallengeEntity(long challengeId, long thrownBy, long gameId, boolean challengeStatus, Date dateOfChallenge, String invitationMessage) {
        this.challengeId = challengeId;
        this.thrownBy = thrownBy;
        this.gameId = gameId;
        this.challengeStatus = challengeStatus;
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

    public boolean isChallengeStatus() {
        return challengeStatus;
    }

    public void setChallengeStatus(boolean challengeStatus) {
        this.challengeStatus = challengeStatus;
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
