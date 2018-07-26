package com.capgemini.challenges;

import com.capgemini.challenges.abilitytime.AbilityTimeEntity;
import com.capgemini.challenges.abilitytime.DayOfWeek;
import com.capgemini.challenges.abilitytime.TimeOfDay;
import com.capgemini.challenges.abilitytime.dao.AbilityTimeDao;
import com.capgemini.challenges.abilitytime.service.AbilityTimeService;
import com.capgemini.challenges.player.dao.PlayerDAO;
import com.capgemini.challenges.player.dto.PlayerDTO;
import com.capgemini.challenges.player.mapper.PlayerMapper;
import com.capgemini.challenges.player.service.PlayerService;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    PlayerDAO playerDAO = new PlayerDAO();
    PlayerMapper playerMapper = new PlayerMapper();
    AbilityTimeDao abilityTimeDao = new AbilityTimeDao();
    AbilityTimeService abilityTimeService = new AbilityTimeService(abilityTimeDao);
    PlayerService playerService = new PlayerService(playerDAO, playerMapper, abilityTimeService);

    @After
    public void emptyList() {
        PlayerDAO.setIdCounter(0);
    }

    @Test
    public void shouldAssertEqualsBecauseSuchUserExists() {
        //given

        //when
        List<PlayerDTO> players = playerService.searchPlayerByUsername("peja");

        //then
        assertThat(players.size()).isEqualTo(1);
        assertThat(players.get(0).getUsername()).isEqualTo("peja");
    }

    @Test
    public void shouldAssertEqualsBecauseTwoPlayersHaveThisGame() {
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

    @Test
    public void shouldAssertEqualsBecauseTwoPlayersHaveThisAbilityTime() {
        //given
        AbilityTimeEntity abilityTime = new AbilityTimeEntity(DayOfWeek.MONDAY, TimeOfDay.AFTERNOON);

        //when
        List<PlayerDTO> players = playerService.searchPlayerByAbilityTime(abilityTime);

        //then
        assertThat(players.size()).isEqualTo(2);
    }
}
