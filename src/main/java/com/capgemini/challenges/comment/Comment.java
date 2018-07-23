package com.capgemini.challenges.comment;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.player.Player;

import java.util.Date;

public class Comment {

    private long commentId;

    private Player player;
    private Challenge challenge;

    private Date dateOfComment;

    public Comment(Player player, Challenge challenge, Date dateOfComment) {
        this.player = player;
        this.challenge = challenge;
        this.dateOfComment = dateOfComment;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }
}
