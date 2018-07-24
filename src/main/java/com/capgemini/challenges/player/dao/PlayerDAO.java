package com.capgemini.challenges.player.dao;

import com.capgemini.challenges.player.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDAO {

    private static long idCounter = 0;
    private List<Player> players = new ArrayList<>();

    public PlayerDAO() {
        addPlayers();
    }

    private void addPlayers(){
        players.add(new Player(createID(),"koxik1993"));
        players.add(new Player(createID(),"eminiem"));
        players.add(new Player(createID(),"rutowicz"));
        players.add(new Player(createID(),"tede"));
        players.add(new Player(createID(),"peja"));
    }

    public List<Player> getPlayers() {
        return players;
    }

    private static long createID() {
        return idCounter++;
    }
}
