package com.capgemini.challenges;

import com.capgemini.challenges.player.PlayerEntity;
import com.capgemini.challenges.player.dao.PlayerDAO;
import com.capgemini.challenges.player.service.PlayerService;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    PlayerDAO playerDAO = new PlayerDAO();
    PlayerService playerService = new PlayerService(playerDAO);

    @Test
    public void shouldAssertEqualsBecauseSuchUserExists(){
        //given

        //when
        List<PlayerEntity> players = playerService.searchPlayerByUsername("peja");

        //then
        assertThat(players.size()).isEqualTo(1);
        assertThat(players.get(0).getUsername()).isEqualTo("peja");
    }

    @Test
    public void shouldAssertEqualsBecauseTwoPlayersHaveThisGame(){
        //given

        //when
        List<PlayerEntity> players = playerService.searchPlayerByOwnedGames("Chess");
        List<PlayerEntity> players2 = playerService.searchPlayerByOwnedGames("NotChess");
        List<PlayerEntity> players3 = playerService.searchPlayerByOwnedGames("Avalon");

        //then
        assertThat(players.size()).isEqualTo(2);
        assertThat(players2.size()).isEqualTo(0);
        assertThat(players3.size()).isEqualTo(1);
    }
}
