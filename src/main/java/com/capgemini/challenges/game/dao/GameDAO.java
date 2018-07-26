package com.capgemini.challenges.game.dao;

import com.capgemini.challenges.game.GameEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameDAO {
    private List<GameEntity> listOfGames = new ArrayList<>();

    public GameDAO() {
        addGames();
    }

    private void addGames() {
        listOfGames.add(new GameEntity("Chess"));
        listOfGames.add(new GameEntity("Gloomhaven"));
        listOfGames.add(new GameEntity("Runewars"));
        listOfGames.add(new GameEntity("Bang"));
        listOfGames.add(new GameEntity("Avalon"));
    }

    public List<GameEntity> getListOfGames() {
        return listOfGames;
    }
}
