package com.capgemini.challenges.game.dao;

import com.capgemini.challenges.game.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class GameDAO {
    private List<Game> listOfGames = new ArrayList<>();

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

    public List<Game> getListOfGames() {
        return listOfGames;
    }

    public Game findGameByName(String gameName){
        Stream<Game> stream = listOfGames.stream();
        Game game = stream.filter(g -> g.getName().equals(gameName)).findFirst().get();
        return game;
    }
}
