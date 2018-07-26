package com.capgemini.challenges.challengeparticipation.dao;

import com.capgemini.challenges.challengeparticipation.ChallengeParticipationEntity;
import com.capgemini.challenges.challengeparticipation.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ChallengeParticipationDAO {
    private static long idCounter = 0;
    private List<ChallengeParticipationEntity> challengeParticipations = new ArrayList<>();

    private static long createID() {
        return idCounter++;
    }

    @Autowired
    public ChallengeParticipationDAO() {
        addChallengesParticipation();
    }

    public ChallengeParticipationEntity findChallengeParticipationById(long id) {
        return challengeParticipations.stream().filter(c -> c.getChallengeParticipationId() == id).findFirst().get();
    }

    private void addChallengesParticipation() {
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 1, 0, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 2, 1, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 0, 3, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 2, 4, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 2, 5, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 4, 1, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 4, 2, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 4, 3, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 0, 0, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 1, 1, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 0, 1, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 1, 2, UserStatus.UNDECIDED, ""));
    }

    public void addChallengeParticipation(ChallengeParticipationEntity challengeParticipation) {
        challengeParticipation.setChallengeParticipationId(createID());
        challengeParticipations.add(challengeParticipation);
    }

    public List<ChallengeParticipationEntity> findAllChallengeParticipationsByPlayer(long playerId) {
        return challengeParticipations.stream().filter(c -> c.getUserId() == playerId).collect(Collectors.toList());
    }

    public List<ChallengeParticipationEntity> findAllChallengesAcceptedByPlayer(long playerId) {
        return findAllChallengeParticipationsByPlayer(playerId).stream().filter(c -> c.getUserStatus().equals(UserStatus.ACCEPTED)).collect(Collectors.toList());
    }

    public List<ChallengeParticipationEntity> findChallengeParticipationsByChallenge(long challengeId) {
        return challengeParticipations.stream().filter(c -> c.getChallengeId() == challengeId).collect(Collectors.toList());
    }

    public List<Long> findOpponentsInChallenge(long challengeId) {
        return findChallengeParticipationsByChallenge(challengeId).stream().map(c -> c.getUserId()).collect(Collectors.toList());
    }

    public static void setIdCounter(long idCounter) {
        ChallengeParticipationDAO.idCounter = idCounter;
    }

}
