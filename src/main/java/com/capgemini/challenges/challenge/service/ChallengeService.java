package com.capgemini.challenges.challenge.service;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ChallengeService {
    private ChallengeDAO challengeDAO;

    @Autowired
    public ChallengeService(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    public void createChallenge(long challengeId, long gameId, long playerOneId, long plyerTwoId){
        Challenge challenge = new Challenge();
        challenge.setChallengeId(challengeId);
        challenge.setGameId(gameId);
        challenge.setPlayerOneId(playerOneId);
        challenge.setPlayerTwoId(plyerTwoId);
        challenge.setDateOfChallenge(new Date());
        challenge.setGameStatus(false);
        challenge.setStatusPlayerOne(false);
        challenge.setStatusPlayerTwo(false);
        challengeDAO.getChallenges().add(challenge);
    }
}
