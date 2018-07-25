package com.capgemini.challenges.challenge.service;

import com.capgemini.challenges.challenge.ChallengeEntity;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challengeParticipation.dao.ChallengeParticipationDao;
import com.capgemini.challenges.challengeParticipation.service.ChallengeParticipationService;
import com.capgemini.challenges.player.Player;
import com.capgemini.challenges.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ChallengeService {
    private final static long SYSTEM_ID = -1;
    private ChallengeDAO challengeDAO;
    private PlayerService playerService;
    private ChallengeParticipationService challengeParticipationService;

    @Autowired
    public ChallengeService(ChallengeDAO challengeDAO, PlayerService playerService, ChallengeParticipationService challengeParticipationService) {
        this.challengeDAO = challengeDAO;
        this.playerService = playerService;
        this.challengeParticipationService = challengeParticipationService;
    }

    public void createChallenge(long playerId, long gameId, List<Long> playersId, String message) {
        ChallengeEntity challenge = new ChallengeEntity();
        challenge.setThrownBy(playerId);
        challenge.setGameId(gameId);
        challenge.setDateOfChallenge(new Date());
        challenge.setInvitationMessage(message);
        challenge.setChallengeStatus(false);

        challengeDAO.addChallenge(challenge);
        challengeParticipationService.createChallengeParticipations(challenge.getChallengeId(), playersId);
    }

    //to chyba moze byc tutaj ale moze w participation, to na razie niewymagane
   // private void checkingDeclined(ChallengeEntity challenge) {
 //       Collection<UserStatus> collection = challenge.getUserDecision().values();
    //    Stream<UserStatus> stream = collection.stream();
    //    long countDeclined = stream.filter(u -> u.equals(UserStatus.DECLINED)).count();
    //    if (countDeclined == challenge.getUserDecision().size()) {
    //        challengeDAO.removeChallenge(challenge);
   //     }
   // }

    //to chyba moze byc tutaj ale moze w participation
    public List<ChallengeEntity> showAcceptedChallenges(long playerId) {
        List<ChallengeEntity> challenges = challengeDAO.findAllChallenges();
        List<ChallengeEntity> challengeList = new ArrayList<>();


        //musze miec idPlayera i szukam po participations jego id i tam gdzie jest accepted to zwracam po id challenge i dodaje do listy
        for (ChallengeEntity challenge : challenges
                ) {
            UserStatus userDecision = challenge.getUserDecision().get(playerId);
            if (userDecision != null && userDecision.equals(UserStatus.ACCEPTED)) {
                challengeList.add(challenge);
            }
        }

        return challengeList;
    }

    //to chyba spoko
    public List<ChallengeEntity> showChallengesCreatedBySystem() {
        return showChallengesThrownBy(SYSTEM_ID);
    }

    //to chyba tez
    public List<ChallengeEntity> showChallengesThrownBy(long playerId) {
        List<ChallengeEntity> challenges = challengeDAO.findAllChallenges();
        List<ChallengeEntity> challengeList = challenges.stream().filter(c -> c.getThrownBy() == playerId).collect(Collectors.toList());

        return challengeList;
    }

    //to szukac w participation i zwracac challenge po id
    public List<ChallengeEntity> showChallengesThrownAt(long playerId) {
        List<ChallengeEntity> challenges = challengeDAO.findAllChallenges();
        List<ChallengeEntity> challengeList = new ArrayList<>();
        for (ChallengeEntity challenge : challenges) {
            Map<Long, UserStatus> usersDecisions = challenge.getUserDecision();
            if (usersDecisions.containsKey(playerId) && challenge.getThrownBy() != playerId) {
                challengeList.add(challenge);
            }
        }

        return challengeList;
    }

    public List<Player> showOpponentsInfoBySelectingChallenge(long challengeId){
        ChallengeEntity challenge = challengeDAO.findChallengeById(challengeId);
        Map<Long, UserStatus> usersDecisions = challenge.getUserDecision();
        List<Long> playersId = new ArrayList<>(usersDecisions.keySet());
        List<Player> players = new ArrayList<>();

        for (Long id: playersId) {
            Player player = playerService.findPlayer(id);
            players.add(player);
        }

        return players;
    }

    public void endOfChallenge(long winnerId, long challengeId) {
        ChallengeEntity challenge = challengeDAO.findChallengeById(challengeId);
        challenge.setGameStatus(true);
        int points = 10;
        playerService.addPoints(winnerId, points);
    }

    //zapisywanie informacji o zakonczonej grze, dokonczyc
    public void saveChallenge(long challengeId){
        ChallengeEntity challenge = challengeDAO.findChallengeById(challengeId);
        if (challenge.isGameStatus()){

        }
    }
}
