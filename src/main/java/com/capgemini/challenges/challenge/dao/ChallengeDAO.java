package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Long> players = new ArrayList<>();
        players.add(0L);
        players.add(1L);
        players.add(2L);
        List<UserStatus> playersStatuses = new ArrayList<>();
        playersStatuses.add(UserStatus.UNDECIDED);
        playersStatuses.add(UserStatus.UNDECIDED);
        playersStatuses.add(UserStatus.UNDECIDED);
        challenges.add(new Challenge(createID(), players, 2, playersStatuses, false, new Date()));
        challenges.add(new Challenge(createID(), players, 3, playersStatuses, false, new Date()));
        challenges.add(new Challenge(createID(), players, 4, playersStatuses, false, new Date()));
        challenges.add(new Challenge(createID(), players, 5, playersStatuses, false, new Date()));
        challenges.add(new Challenge(createID(), players, 6, playersStatuses, false, new Date()));
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
