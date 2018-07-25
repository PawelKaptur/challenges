package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.ChallengeEntity;
import com.capgemini.challenges.challenge.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
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
        String message = "hej";
        String message2 = "hejhej";
        String message3 = "hejhejhej";
        String message4 = "hejhejhejhej";
        String message5 = "hejhejhejhejhejhejhej";
        String message6 = "hejhejhejhejhejhejhejhejhejhej";
        challenges.add(new ChallengeEntity(createID(), -1,  2, false, new Date(),message));
        challenges.add(new ChallengeEntity(createID(), 2,  3, false, new Date(),message2));
        challenges.add(new ChallengeEntity(createID(), 4, 4, false, new Date(),message3));
        challenges.add(new ChallengeEntity(createID(), 0, 5, false, new Date(),message4));
        challenges.add(new ChallengeEntity(createID(), 2, 6, false, new Date(),message5));
        challenges.add(new ChallengeEntity(createID(), -1,4,false, new Date(),message6));
    }


    //w bazie danych juz streamy robic a nie w serwisie takze komentarz w srodku spoko, tylko do innej metody
    public List<ChallengeEntity> findAllChallenges() {
        // challenges.stream().filter(c -> c.getThrownBy() == playerId).collect(Collectors.toList());
        return challenges;
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

    public void removeChallenge(ChallengeEntity challenge) {
        challenges.remove(challenge);
    }

    public static void setIdCounter(long idCounter) {
        ChallengeDAO.idCounter = idCounter;
    }
}
