package com.capgemini.challenges.game.dao;

import com.capgemini.challenges.game.Game;

import java.util.ArrayList;
import java.util.List;

public class GameDAO {
    private static List<Game> listOfGames = new ArrayList<>();

    public GameDAO() {
        addGames();
    }

    private void addGames(){
        listOfGames.add(new Game("Chess"));
        listOfGames.add(new Game("Gloomhaven"));
        listOfGames.add(new Game("Runewars"));
        listOfGames.add(new Game("Bang"));
        listOfGames.add(new Game("Avalon"));
    }
}
