package com.capgemini.challenges;

import com.capgemini.challenges.player.PlayerEntity;
import com.capgemini.challenges.player.dao.PlayerDAO;
import com.capgemini.challenges.player.dto.PlayerDTO;
import com.capgemini.challenges.player.mapper.PlayerMapper;
import com.capgemini.challenges.player.service.PlayerService;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    PlayerDAO playerDAO = new PlayerDAO();
    PlayerMapper playerMapper = new PlayerMapper();
    PlayerService playerService = new PlayerService(playerDAO, playerMapper);

    @Test
    public void shouldAssertEqualsBecauseSuchUserExists(){
        //given

        //when
        List<PlayerDTO> players = playerService.searchPlayerByUsername("peja");

        //then
        assertThat(players.size()).isEqualTo(1);
        assertThat(players.get(0).getUsername()).isEqualTo("peja");
    }

    @Test
    public void shouldAssertEqualsBecauseTwoPlayersHaveThisGame(){
        //given

        //when
        List<PlayerDTO> players = playerService.searchPlayerByOwnedGames("Chess");
        List<PlayerDTO> players2 = playerService.searchPlayerByOwnedGames("NotChess");
        List<PlayerDTO> players3 = playerService.searchPlayerByOwnedGames("Avalon");

        //then
        assertThat(players.size()).isEqualTo(2);
        assertThat(players2.size()).isEqualTo(0);
        assertThat(players3.size()).isEqualTo(1);
    }
}
