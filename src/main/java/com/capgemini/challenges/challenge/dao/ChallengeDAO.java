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
        Map<Long, UserStatus> userDecision2 = new TreeMap<>();
        userDecision2.put(2L, UserStatus.UNDECIDED);
        userDecision2.put(1L, UserStatus.UNDECIDED);
        userDecision2.put(4L, UserStatus.UNDECIDED);
        Map<Long, UserStatus> userDecision3 = new TreeMap<>();
        userDecision3.put(2L, UserStatus.UNDECIDED);
        userDecision3.put(4L, UserStatus.UNDECIDED);
        Map<Long, UserStatus> userDecision4 = new TreeMap<>();
        userDecision4.put(2L, UserStatus.UNDECIDED);
        userDecision4.put(0L, UserStatus.UNDECIDED);
        userDecision4.put(4L, UserStatus.UNDECIDED);
        Map<Long, UserStatus> userDecision5 = new TreeMap<>();
        userDecision5.put(2L, UserStatus.UNDECIDED);
        userDecision5.put(3L, UserStatus.UNDECIDED);
        Map<Long, UserStatus> userDecision6 = new TreeMap<>();
        userDecision6.put(2L, UserStatus.UNDECIDED);
        userDecision6.put(3L, UserStatus.UNDECIDED);
        challenges.add(new Challenge(createID(), -1, userDecision, 2, false, new Date()));
        challenges.add(new Challenge(createID(), 2, userDecision2, 3, false, new Date()));
        challenges.add(new Challenge(createID(), 4, userDecision3, 4, false, new Date()));
        challenges.add(new Challenge(createID(), 0,userDecision4, 5, false, new Date()));
        challenges.add(new Challenge(createID(), 2,userDecision5, 6, false, new Date()));
        challenges.add(new Challenge(createID(), -1,userDecision6,4,false, new Date()));
    }

    public List<Challenge> findAllChallenges() {
        return challenges;
    }

    //to obczaic czy spoko
    public Challenge findChallengeById(long id) {
        //Stream<Challenge> stream = challenges.stream();
        //Challenge challenge = (Challenge) stream.filter(c -> c.getGameId() == id);
        //return challenge;
        //for (Challenge challenge : challenges) {
          //  if (challenge.getChallengeId() == id) {
          //      return challenge;
          //  }
        //}
        for(int i = 0; i < challenges.size(); i++){
            if(challenges.get(i).getChallengeId() == id){
                return challenges.get(i);
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
