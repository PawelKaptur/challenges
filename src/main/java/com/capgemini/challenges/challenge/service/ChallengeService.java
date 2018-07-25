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
    private ChallengeDAO challengeDAO;

    @Autowired
    public ChallengeService(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    //jakis validator ze playerId nie moze sie powtarzac, moze set?, albo mapa i od razu statusy tam tez wbic
    public void createChallenge(long gameId, Map<Long, UserStatus> usersDecisions) {
        Challenge challenge = new Challenge();
        challenge.setGameId(gameId);
        //challenge.setPlayersId(playersId);
        challenge.setUserDecision(usersDecisions);
        challenge.setDateOfChallenge(new Date());
        challenge.setGameStatus(false);
        challengeDAO.addChallenge(challenge);
    }

    public void acceptChallenge(long playerId, Map<Long, UserStatus> usersDecisions) {
        //statuses.set(playerNumber, UserStatus.ACCEPTED);
        usersDecisions.put(playerId, UserStatus.ACCEPTED);
    }

    public void declineChallenge(long playerId, Map<Long, UserStatus> usersDecisions, Challenge challenge) {
        //statuses.set(playerNumber, UserStatus.DECLINED);
        usersDecisions.put(playerId, UserStatus.DECLINED);
        checkingDeclined(challenge);
    }

    // Map<Long, UserStatus> usersDecisions
    public void modifyStatuses(long playerId, long challengeId, UserStatus userStatus) {
        Challenge challenge = challengeDAO.findChallengeById(challengeId);
        //int playerNumber = challenge.getPlayersId().indexOf(playerId);
        //List<UserStatus> statuses = challenge.getStatusesOfPlayers();
        Map<Long, UserStatus> usersDecisions = challenge.getUserDecision();
        //UserStatus userDecision = usersDecisions.get(playerId);

        if (userStatus.equals(UserStatus.ACCEPTED)) {
            acceptChallenge(playerId, usersDecisions);
        } else {
            declineChallenge(playerId, usersDecisions, challenge);
        }
    }

    //zrobic streama z tego
    private void checkingDeclined(Challenge challenge) {
        int countDeclined = 0;
      //  for (UserStatus status : challenge.getStatusesOfPlayers()) {
       //     if (!status.equals(UserStatus.DECLINED)) {
        //        break;
        //    } else {
        //        countDeclined++;
       //         continue;
         //   }
       // }
        for (UserStatus value: challenge.getUserDecision().values()
             ) {
            if(!value.equals(UserStatus.DECLINED)){
                break;
            }
            else {
                countDeclined++;
                continue;
            }
        }

        if (countDeclined == challenge.getUserDecision().size()) {
            challengeDAO.removeChallenge(challenge);
        }
    }

    public List<Challenge> showAcceptedChallenges(long playerId) {
        List<Challenge> challenges = challengeDAO.findAllChallenges();
        List<Challenge> challengeList = new ArrayList<>();
        for (Challenge challenge : challenges
                ) {
            //int playerNumber = challenge.getPlayersId().indexOf(playerId);
            //List<UserStatus> statuses = challenge.getStatusesOfPlayers();
            UserStatus userDecision = challenge.getUserDecision().get(playerId);
            //UserStatus status = statuses.get(playerNumber);
            if(userDecision.equals(UserStatus.ACCEPTED)){
                challengeList.add(challenge);
            }
        }

        return challengeList;
    }

    //tutaj dodawanie pkt zwyciezcy
    public void endOfChallenge() {

    }
}
