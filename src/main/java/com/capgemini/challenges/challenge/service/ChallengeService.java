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

    //jakis validator ze playerId nie moze sie powtarzac, moze set?
    public void createChallenge(long gameId, List<Long> playersId) {
        Challenge challenge = new Challenge();
        challenge.setGameId(gameId);
        challenge.setPlayersId(playersId);
        challenge.setDateOfChallenge(new Date());
        challenge.setGameStatus(false);
        challengeDAO.addChallenge(challenge);
    }

    public void acceptChallenge(int playerNumber, List<UserStatus> statuses, Challenge challenge) {
        statuses.set(playerNumber, UserStatus.ACCEPTED);
        //nie wiem czy linijka ponizej potrzebna
        //challenge.setStatusesOfPlayers(statuses);
    }

    public void declineChallenge(int playerNumber, List<UserStatus> statuses, Challenge challenge) {
        statuses.set(playerNumber, UserStatus.DECLINED);
        checkingDeclined(challenge);
    }

    public void modifyStatuses(long playerId, long challengeId, UserStatus userStatus) {
        Challenge challenge = challengeDAO.findChallengeById(challengeId);
        int playerNumber = challenge.getPlayersId().indexOf(playerId);
        List<UserStatus> statuses = challenge.getStatusesOfPlayers();

        if (userStatus.equals(UserStatus.ACCEPTED)) {
            acceptChallenge(playerNumber, statuses, challenge);
        } else {
            declineChallenge(playerNumber, statuses, challenge);
        }
    }

    //zrobic streama z tego
    private void checkingDeclined(Challenge challenge) {
        int countDeclined = 0;
        for (UserStatus status : challenge.getStatusesOfPlayers()) {
            if (!status.equals(UserStatus.DECLINED)) {
                break;
            } else {
                countDeclined++;
                continue;
            }
        }

        if (countDeclined == challenge.getStatusesOfPlayers().size()) {
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
