package com.capgemini.challenges.challenge.dto;

import com.capgemini.challenges.game.Game;
import com.capgemini.challenges.player.Player;

import java.util.Date;

public class ChallengeDTO {

    private long challengeId;

    private Player playerOne;
    private Player playerTwo;

    private Game game;

    private boolean statusPlayerOne;
    private boolean statusPlayerTwo;

    private boolean gameStatus;

    private Date dateOfChallenge;
}
