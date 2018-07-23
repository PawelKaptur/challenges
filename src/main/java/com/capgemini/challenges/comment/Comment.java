package com.capgemini.challenges.comment;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.player.Player;

import java.util.Date;

public class Comment {

    private long commentId;

    private long playerId;
    private long challenge;

    private Date dateOfComment;

    public Comment(long playerId, long challenge, Date dateOfComment) {
        this.playerId = playerId;
        this.challenge = challenge;
        this.dateOfComment = dateOfComment;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getChallenge() {
        return challenge;
    }

    public void setChallenge(long challenge) {
        this.challenge = challenge;
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
