package com.capgemini.challenges.challengeParticipation.dao;

import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challengeParticipation.ChallengeParticipationEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ChallengeParticipationDao {
    private static long idCounter = 0;
    private List<ChallengeParticipationEntity> challengeParticipations = new ArrayList<>();

    private static long createID() {
        return idCounter++;
    }

    @Autowired
    public ChallengeParticipationDao() {
        addChallengesParticipation();
    }

    public ChallengeParticipationEntity findChallengeParticipationById(long id) {
        Stream<ChallengeParticipationEntity> stream = challengeParticipations.stream();
        ChallengeParticipationEntity challengeParticipation = stream.filter(c -> c.getChallengeParticipationId() == id).findFirst().get();

        return challengeParticipation;
    }

    private void addChallengesParticipation() {
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 1, 0, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 2, 1, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 4, 2, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 0, 3, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 2, 4, UserStatus.UNDECIDED, ""));
        challengeParticipations.add(new ChallengeParticipationEntity(createID(), 2, 5, UserStatus.UNDECIDED, ""));
    }

    public void addChallengeParticipation(ChallengeParticipationEntity challengeParticipation) {
        challengeParticipation.setChallengeParticipationId(createID());
        challengeParticipations.add(challengeParticipation);
    }
}
