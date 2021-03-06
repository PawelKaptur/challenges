package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.ChallengeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ChallengeDAO {
    private static long idCounter = 0;
    private List<ChallengeEntity> challenges = new ArrayList<>();

    private static long createID() {
        return idCounter++;
    }

    @Autowired
    public ChallengeDAO() {
        addChallenges();
    }

    private void addChallenges() {
        String message = "hi";
        String message2 = "hihihi";
        String message3 = "hihihihi";
        String message4 = "hihihihihi";
        String message5 = "hihihihihihi";
        String message6 = "hihihihihihihi";
        challenges.add(new ChallengeEntity(createID(), -1, 2, false, new Date(10000000000000L), message));
        challenges.add(new ChallengeEntity(createID(), 2, 3, false, new Date(10000000000001L), message2));
        challenges.add(new ChallengeEntity(createID(), 4, 4, false, new Date(10000000000002L), message3));
        challenges.add(new ChallengeEntity(createID(), 0, 5, false, new Date(10000000000003L), message4));
        challenges.add(new ChallengeEntity(createID(), 2, 6, false, new Date(10000000000004L), message5));
        challenges.add(new ChallengeEntity(createID(), -1, 4, false, new Date(10000000000005L), message6));
    }

    public List<ChallengeEntity> findAllChallenges() {
        return challenges;
    }

    public List<ChallengeEntity> findChallengesThrownBy(long playerId) {
        return challenges.stream().filter(c -> c.getThrownBy() == playerId).collect(Collectors.toList());
    }

    public ChallengeEntity findChallengeById(long id) {
        return challenges.stream().filter(c -> c.getChallengeId() == id).findFirst().get();
    }

    public void addChallenge(ChallengeEntity challenge) {
        challenge.setChallengeId(createID());
        challenges.add(challenge);
    }

    public static void setIdCounter(long idCounter) {
        ChallengeDAO.idCounter = idCounter;
    }
}
