package com.capgemini.challenges.challenge.service;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.player.Player;
import com.capgemini.challenges.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ChallengeService {
    private final static long SYSTEM_ID = -1;
    private ChallengeDAO challengeDAO;
    private PlayerService playerService;

    @Autowired
    public ChallengeService(ChallengeDAO challengeDAO, PlayerService playerService) {
        this.challengeDAO = challengeDAO;
        this.playerService = playerService;
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

    public List<Player> showOpponentsInfoBySelectingChallenge(long challengeId){
        Challenge challenge = challengeDAO.findChallengeById(challengeId);
        Map<Long, UserStatus> usersDecisions = challenge.getUserDecision();
        List<Long> playersId = new ArrayList<>(usersDecisions.keySet());
        List<Player> players = new ArrayList<>();

        for (Long id: playersId) {
            Player player = playerService.findPlayer(id);
            players.add(player);
        }

        return players;
    }

    //tutaj dodawanie pkt zwyciezcy
    public void endOfChallenge() {

    }
}
