package com.capgemini.challenges.player.dao;

import com.capgemini.challenges.player.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDAO {

    private List<Player> players = new ArrayList<>();

    public PlayerDAO() {
        addPlayers();
    }

    private void addPlayers(){
        players.add(new Player("koxik1993"));
        players.add(new Player("eminiem"));
        players.add(new Player("rutowicz"));
        players.add(new Player("tede"));
        players.add(new Player("peja"));
    }

    public List<Player> getPlayers() {
        return players;
    }


}
