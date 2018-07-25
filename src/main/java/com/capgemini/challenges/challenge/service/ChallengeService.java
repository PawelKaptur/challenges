package com.capgemini.challenges.challenge.service;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ChallengeService {
    private final static long SYSTEM_ID = -1;
    private ChallengeDAO challengeDAO;

    @Autowired
    public ChallengeService(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    public void createChallenge(long gameId, Map<Long, UserStatus> usersDecisions) {
        Challenge challenge = new Challenge();
        challenge.setGameId(gameId);
        challenge.setUserDecision(usersDecisions);
        challenge.setDateOfChallenge(new Date());
        challenge.setGameStatus(false);
        challengeDAO.addChallenge(challenge);
    }

    public void acceptChallenge(long playerId, Map<Long, UserStatus> usersDecisions) {
        usersDecisions.put(playerId, UserStatus.ACCEPTED);
    }

    public void declineChallenge(long playerId, Map<Long, UserStatus> usersDecisions, Challenge challenge) {
        usersDecisions.put(playerId, UserStatus.DECLINED);
        checkingDeclined(challenge);
    }

    public void modifyStatuses(long playerId, long challengeId, UserStatus userStatus) {
        Challenge challenge = challengeDAO.findChallengeById(challengeId);
        Map<Long, UserStatus> usersDecisions = challenge.getUserDecision();

        if (userStatus.equals(UserStatus.ACCEPTED)) {
            acceptChallenge(playerId, usersDecisions);
        } else {
            declineChallenge(playerId, usersDecisions, challenge);
        }
    }

    //zrobic streama z tego, chyba
    private void checkingDeclined(Challenge challenge) {
        int countDeclined = 0;
        for (UserStatus value : challenge.getUserDecision().values()
                ) {
            if (!value.equals(UserStatus.DECLINED)) {
                break;
            } else {
                countDeclined++;
                continue;
            }
        }

        if (countDeclined == challenge.getUserDecision().size()) {
            challengeDAO.removeChallenge(challenge);
        }
    }

    //tu bedzie mozna streama uzyc
    public List<Challenge> showAcceptedChallenges(long playerId) {
        List<Challenge> challenges = challengeDAO.findAllChallenges();
        List<Challenge> challengeList = new ArrayList<>();
        for (Challenge challenge : challenges
                ) {
            UserStatus userDecision = challenge.getUserDecision().get(playerId);
            if (userDecision != null && userDecision.equals(UserStatus.ACCEPTED)) {
                challengeList.add(challenge);
            }
        }

        return challengeList;
    }

    public List<Challenge> showChallengesCreatedBySystem() {
        return showChallengesThrownBy(SYSTEM_ID);
    }

    public List<Challenge> showChallengesThrownBy(long playerId) {
        List<Challenge> challenges = challengeDAO.findAllChallenges();
        List<Challenge> challengeList = new ArrayList<>();
        for (Challenge challenge : challenges
                ) {
            if (challenge.getThrownBy() == playerId) {
                challengeList.add(challenge);
            }
        }

        return challengeList;
    }

    public List<Challenge> showChallengesThrownAt(long playerId) {
        List<Challenge> challenges = challengeDAO.findAllChallenges();
        List<Challenge> challengeList = new ArrayList<>();
        for (Challenge challenge : challenges) {
            Map<Long, UserStatus> usersDecisions = challenge.getUserDecision();
            if (usersDecisions.containsKey(playerId) && challenge.getThrownBy() != playerId) {
                challengeList.add(challenge);
            }
        }

        return challengeList;
    }

    //tutaj dodawanie pkt zwyciezcy
    public void endOfChallenge() {

    }
}
