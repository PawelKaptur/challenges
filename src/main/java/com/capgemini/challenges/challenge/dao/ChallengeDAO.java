package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.Challenge;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ChallengeDAO {
    private List<Challenge> challenges = new ArrayList<>();

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


}
