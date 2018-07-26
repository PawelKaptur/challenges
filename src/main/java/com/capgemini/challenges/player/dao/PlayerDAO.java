package com.capgemini.challenges.player.dao;

import com.capgemini.challenges.game.GameEntity;
import com.capgemini.challenges.game.dao.GameDAO;
import com.capgemini.challenges.player.PlayerEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlayerDAO {

    private static long idCounter = 0;
    private List<PlayerEntity> players = new ArrayList<>();
    private GameDAO gameDAO = new GameDAO();

    public PlayerDAO() {
        addPlayers();
    }

    private void addPlayers() {
        List<GameEntity> listOfGames = gameDAO.getListOfGames().subList(0, 2);
        List<GameEntity> listOfGames2 = gameDAO.getListOfGames().subList(1, 2);
        List<GameEntity> listOfGames3 = gameDAO.getListOfGames().subList(3, 4);
        List<GameEntity> listOfGames4 = gameDAO.getListOfGames();
        List<GameEntity> listOfGames5 = gameDAO.getListOfGames().subList(1, 3);
        players.add(new PlayerEntity(createID(), "koxik1993", listOfGames));
        players.add(new PlayerEntity(createID(), "eminiem", listOfGames2));
        players.add(new PlayerEntity(createID(), "rutowicz", listOfGames3));
        players.add(new PlayerEntity(createID(), "tede", listOfGames4));
        players.add(new PlayerEntity(createID(), "peja", listOfGames5));
    }

    private static long createID() {
        return idCounter++;
    }

    public PlayerEntity findPlayerById(long playerId) {
        return players.stream().filter(p -> p.getPlayerId() == playerId).findFirst().get();
    }

    public List<PlayerEntity> findPlayersByUsername(String username) {
        return players.stream().filter(p -> p.getUsername().equals(username)).collect(Collectors.toList());
    }

    public List<PlayerEntity> findPlayersByOwnedGames(String gameName) {
        List<PlayerEntity> foundPlayers = new ArrayList<>();
        for (PlayerEntity player : players) {
            for (GameEntity game : player.getListOfOwnedGames()) {
                if (game.getName().equals(gameName)) {
                    foundPlayers.add(player);
                }
            }
        }

        return foundPlayers;
    }

    public static void setIdCounter(long idCounter) {
        PlayerDAO.idCounter = idCounter;
    }
}
