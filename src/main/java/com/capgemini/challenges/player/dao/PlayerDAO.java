package com.capgemini.challenges.player.dao;

import com.capgemini.challenges.game.Game;
import com.capgemini.challenges.game.dao.GameDAO;
import com.capgemini.challenges.player.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDAO {

    private static long idCounter = 0;
    private List<Player> players = new ArrayList<>();
    private GameDAO gameDAO = new GameDAO();

    public PlayerDAO() {
        addPlayers();
    }

    private void addPlayers() {
        List<Game> listOfGames = gameDAO.getListOfGames().subList(0, 2);
        List<Game> listOfGames2 = gameDAO.getListOfGames().subList(1, 2);
        List<Game> listOfGames3 = gameDAO.getListOfGames().subList(3, 4);
        List<Game> listOfGames4 = gameDAO.getListOfGames();
        List<Game> listOfGames5 = gameDAO.getListOfGames().subList(1, 3);
        players.add(new Player(createID(), "koxik1993", listOfGames));
        players.add(new Player(createID(), "eminiem", listOfGames2));
        players.add(new Player(createID(), "rutowicz", listOfGames3));
        players.add(new Player(createID(), "tede", listOfGames4));
        players.add(new Player(createID(), "peja", listOfGames5));
    }

    private static long createID() {
        return idCounter++;
    }

    public List<Player> findAllPlayers() {
        return players;
    }

    public Player findPlayerById(long playerId) {

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerId() == playerId) {
                return players.get(i);
            }
        }

        return null;
    }

    public static void setIdCounter(long idCounter) {
        PlayerDAO.idCounter = idCounter;
    }
}
