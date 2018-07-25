package com.capgemini.challenges.game.service;

import com.capgemini.challenges.game.Game;
import com.capgemini.challenges.game.dao.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class GameService {

    private GameDAO gameDAO;

    @Autowired
    public GameService(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    public Game findGameByName(String gameName){
        return gameDAO.findGameByName(gameName);
    }
}
