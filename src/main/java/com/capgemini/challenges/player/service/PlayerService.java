package com.capgemini.challenges.player.service;

import com.capgemini.challenges.player.Player;
import com.capgemini.challenges.player.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {

    private PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Player findPlayer(long playerId){
        return playerDAO.findPlayerById(playerId);
    }

    public void addPoints(long playerId, int points){
        Player player = playerDAO.findPlayerById(playerId);
        //System.out.println(player);
        player.setScore(player.getScore() + points);
    }
}
