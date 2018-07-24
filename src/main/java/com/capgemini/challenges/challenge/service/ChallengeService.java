package com.capgemini.challenges.challenge.service;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ChallengeService {
    private ChallengeDAO challengeDAO;

    @Autowired
    public ChallengeService(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    //jakis validator ze playerOneId nie moze byc rowny z playerTwoId
    public void createChallenge(long gameId, List<Long> playersId) {
        Challenge challenge = new Challenge();
        challenge.setGameId(gameId);
        challenge.setPlayersId(playersId);
        challenge.setDateOfChallenge(new Date());
        challenge.setGameStatus(false);
        challengeDAO.addChallenge(challenge);
    }

    //usunac duplikaty pozniej
    //beda potrzebne validatory czy challenge jest konkretnego usera i tylko on moze odrzucic lub przyjac, jesli przyjma dwie osoby to reszta nie moze
    public void acceptChallenge(long playerId, long challengeId) {
        Challenge challenge = challengeDAO.findChallengeById(challengeId);
        int playerNumber = challenge.getPlayersId().indexOf(playerId);
        List<UserStatus> statuses = challenge.getStatusesOfPlayers();
        statuses.set(playerNumber, UserStatus.ACCEPTED);
        challenge.setStatusesOfPlayers(statuses);
        //challengeDAO.addChallenge(challenge);
    }

    //tutaj by sie przdalo sprawdzic czy wszyscy odrzucili challenge, jak tak to usunac
    public void declineChallenge(long playerId, long challengeId) {
        Challenge challenge = challengeDAO.findChallengeById(challengeId);
        int playerNumber = challenge.getPlayersId().indexOf(playerId);
        List<UserStatus> statuses = challenge.getStatusesOfPlayers();
        statuses.set(playerNumber, UserStatus.DECLINED);

        //to pojdzie do osobnej metody i zrobic streama z tego
        int countDeclined = 0;
        for (UserStatus status : challenge.getStatusesOfPlayers()) {
            if (!status.equals(UserStatus.DECLINED)) {
                break;
            } else {
                countDeclined++;
                continue;
            }
        }

        if(countDeclined == challenge.getStatusesOfPlayers().size()){
            challengeDAO.removeChallenge(challenge);
        }
    }

    public List<Challenge> showAcceptedChallenges(long playerId) {
        return null;
    }

    //tutaj dodawanie pkt zwyciezcy
    public void endOfChallenge() {

    }
}
