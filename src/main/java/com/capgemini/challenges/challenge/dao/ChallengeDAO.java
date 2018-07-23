package com.capgemini.challenges.challenge.dao;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.player.dao.PlayerDAO;

import java.util.ArrayList;
import java.util.List;

public class ChallengeDAO {
    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeDAO() {
        addChallenges();
    }

    public void addChallenges(){
        //challenges.add(new Challenge(PlayerDAO.getPlayers().get(0), PlayerDAO.getPlayers().get(1), ));
    }

}
