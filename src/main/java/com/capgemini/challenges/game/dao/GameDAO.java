package com.capgemini.challenges.game.dao;

import com.capgemini.challenges.game.GameEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameDAO {
    private static long idCounter = 0;
    private List<GameEntity> listOfGames = new ArrayList<>();

    public GameDAO() {
        addGames();
    }

    private void addGames() {
        listOfGames.add(new GameEntity(createID(), "Chess"));
        listOfGames.add(new GameEntity(createID(), "Gloomhaven"));
        listOfGames.add(new GameEntity(createID(), "Runewars"));
        listOfGames.add(new GameEntity(createID(), "Bang"));
        listOfGames.add(new GameEntity(createID(), "Avalon"));
    }

    public List<GameEntity> getListOfGames() {
        return listOfGames;
    }

    private static long createID() {
        return idCounter++;
    }
}
