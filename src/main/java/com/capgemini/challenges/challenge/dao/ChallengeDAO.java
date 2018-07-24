package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class ChallengeDAO {
    private List<Challenge> challenges = new ArrayList<>();

    @Autowired
    public ChallengeDAO() {
        addChallenges();
    }

    private void addChallenges(){
        challenges.add(new Challenge(0, 1, 0, false, false, false, new Date()));
        challenges.add(new Challenge(2, 3, 1, false, false, false, new Date()));
        challenges.add(new Challenge(0, 2, 2, false, false, false, new Date()));
        challenges.add(new Challenge(0, 4, 3, false, false, false, new Date()));
        challenges.add(new Challenge(2, 4, 4, false, false, false, new Date()));
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }


    //to obczaic czy spoko
    public Challenge findChallengeById(long id){
        Stream<Challenge> stream = challenges.stream();
        Challenge challenge = (Challenge) stream.filter(c -> c.getGameId() == id);
        return challenge;
    }

    public void addChallenge(Challenge challenge){
        challenges.add(challenge);
    }

    public void removeChallenge(Challenge challenge){
        challenges.remove(challenge);
    }
}
