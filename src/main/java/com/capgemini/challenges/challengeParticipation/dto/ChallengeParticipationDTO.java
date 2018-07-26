package com.capgemini.challenges.challengeParticipation.dto;

import com.capgemini.challenges.challenge.UserStatus;

public class ChallengeParticipationDTO {
    private long challengeParticipationId;

    private long userId;
    private long challengeId;
    private UserStatus userStatus;
    private String comment;

    public ChallengeParticipationDTO(long challengeParticipationId, long userId, long challengeId, UserStatus userStatus, String comment) {
        this.challengeParticipationId = challengeParticipationId;
        this.userId = userId;
        this.challengeId = challengeId;
        this.userStatus = userStatus;
        this.comment = comment;
    }

    public ChallengeParticipationDTO() {
    }

    public long getChallengeParticipationId() {
        return challengeParticipationId;
    }

    public void setChallengeParticipationId(long challengeParticipationId) {
        this.challengeParticipationId = challengeParticipationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
