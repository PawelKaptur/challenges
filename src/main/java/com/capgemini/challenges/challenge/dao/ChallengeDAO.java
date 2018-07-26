package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.ChallengeEntity;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challengeparticipation.dto.ChallengeParticipationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        challenges.add(new ChallengeEntity(createID(), -1, 2, false, new Date(), message));
        challenges.add(new ChallengeEntity(createID(), 2, 3, false, new Date(), message2));
        challenges.add(new ChallengeEntity(createID(), 4, 4, false, new Date(), message3));
        challenges.add(new ChallengeEntity(createID(), 0, 5, false, new Date(), message4));
        challenges.add(new ChallengeEntity(createID(), 2, 6, false, new Date(), message5));
        challenges.add(new ChallengeEntity(createID(), -1, 4, false, new Date(), message6));
    }

    public List<ChallengeEntity> findAllChallenges() {
        return challenges;
    }

    public List<ChallengeEntity> findChallengesThrownBy(long playerId) {
        return challenges.stream().filter(c -> c.getThrownBy() == playerId).collect(Collectors.toList());
    }

    public ChallengeEntity findChallengeById(long id) {
        Stream<ChallengeEntity> stream = challenges.stream();
        ChallengeEntity challenge = stream.filter(c -> c.getChallengeId() == id).findFirst().get();

        return challenge;
    }


    public void addChallenge(ChallengeEntity challenge) {
        challenge.setChallengeId(createID());
        challenges.add(challenge);
    }

    public static void setIdCounter(long idCounter) {
        ChallengeDAO.idCounter = idCounter;
    }
}
