package com.capgemini.challenges.player.service;

import com.capgemini.challenges.player.PlayerEntity;
import com.capgemini.challenges.player.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlayerService {

    private PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public PlayerEntity findPlayer(long playerId) {
        return playerDAO.findPlayerById(playerId);
    }

    public void addPoints(long playerId, int points) {
        PlayerEntity player = playerDAO.findPlayerById(playerId);
        player.setScore(player.getScore() + points);
    }

    public List<PlayerEntity> searchPlayerByUsername(String username) {
        List<PlayerEntity> players = playerDAO.findAllPlayers();
        Stream<PlayerEntity> stream = players.stream();
        List<PlayerEntity> foundPlayers = stream.filter(p -> p.getUsername().equals(username)).collect(Collectors.toList());

        return foundPlayers;
    }

    public List<PlayerEntity> searchPlayerByOwnedGames(String gameName) {
        List<PlayerEntity> players = playerDAO.findAllPlayers();
        List<PlayerEntity> foundPlayers = new ArrayList<>();
        for (PlayerEntity player : players) {
            for (int i = 0; i < player.getListOfOwnedGames().size(); i++) {
                if (player.getListOfOwnedGames().get(i).getName().equals(gameName)) {
                    foundPlayers.add(player);
                }
            }
        }

        return foundPlayers;
    }
}
