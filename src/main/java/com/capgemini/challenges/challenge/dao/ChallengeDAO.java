package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChallengeDAO {
    private static long idCounter = 0;
    private List<Challenge> challenges = new ArrayList<>();

    private static long createID() {
        return idCounter++;
    }

    @Autowired
    public ChallengeDAO() {
        addChallenges();
    }

    private void addChallenges() {
        Map<Long, UserStatus> userDecision = new TreeMap<>();
        userDecision.put(0L, UserStatus.UNDECIDED);
        userDecision.put(1L, UserStatus.UNDECIDED);
        userDecision.put(2L, UserStatus.UNDECIDED);
        challenges.add(new Challenge(createID(), userDecision, 2, false, new Date()));
        challenges.add(new Challenge(createID(), userDecision, 3, false, new Date()));
        challenges.add(new Challenge(createID(), userDecision, 4, false, new Date()));
        challenges.add(new Challenge(createID(), userDecision, 5, false, new Date()));
        challenges.add(new Challenge(createID(), userDecision, 6, false, new Date()));
    }

    public List<Challenge> findAllChallenges() {
        return challenges;
    }

    //to obczaic czy spoko
    public Challenge findChallengeById(long id) {
        //Stream<Challenge> stream = challenges.stream();
        //Challenge challenge = (Challenge) stream.filter(c -> c.getGameId() == id);
        //return challenge;
        for (Challenge challenge : challenges) {
            if (challenge.getChallengeId() == id) {
                return challenge;
            }
        }

        return null;
    }

    public void addChallenge(Challenge challenge) {
        challenge.setChallengeId(createID());
        challenges.add(challenge);
    }

    public void removeChallenge(Challenge challenge) {
        challenges.remove(challenge);
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public static void setIdCounter(long idCounter) {
        ChallengeDAO.idCounter = idCounter;
    }
}
