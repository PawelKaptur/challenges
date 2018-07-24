package com.capgemini.challenges.comment;

import java.util.Date;

public class Comment {

    private long commentId;

    private long playerId;
    private long challengeId;

    private Date dateOfComment;

    public Comment(long playerId, long challengeId, Date dateOfComment) {
        this.playerId = playerId;
        this.challengeId = challengeId;
        this.dateOfComment = dateOfComment;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }
}
