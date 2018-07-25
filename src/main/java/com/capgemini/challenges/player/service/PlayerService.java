package com.capgemini.challenges.player.service;

import com.capgemini.challenges.game.Game;
import com.capgemini.challenges.game.service.GameService;
import com.capgemini.challenges.player.Player;
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
    private GameService gameService;

    @Autowired
    public PlayerService(PlayerDAO playerDAO, GameService gameService) {
        this.playerDAO = playerDAO;
        this.gameService = gameService;
    }

    public Player findPlayer(long playerId){
        return playerDAO.findPlayerById(playerId);
    }

    public void addPoints(long playerId, int points){
        Player player = playerDAO.findPlayerById(playerId);
        player.setScore(player.getScore() + points);
    }

    public List<Player> searchPlayerByUsername(String username){
        List<Player> players = playerDAO.findAllPlayers();
        Stream<Player> stream = players.stream();
        List<Player> foundPlayers = stream.filter(p -> p.getUsername().equals(username)).collect(Collectors.toList());

        return foundPlayers;
    }

    public List<Player> searchPlayerByOwnedGames(String gameName){
        List<Player> players = playerDAO.findAllPlayers();
        List<Player> foundPlayers = new ArrayList<>();
        for (Player player: players) {
            for(int i = 0; i < player.getListOfOwnedGames().size(); i++){
                if(player.getListOfOwnedGames().get(i).getName().equals(gameName)){
                    foundPlayers.add(player);
                }
            }

        }

        return foundPlayers;
    }
}
