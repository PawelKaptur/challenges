package com.capgemini.challenges;

import com.capgemini.challenges.abilitytime.AbilityTimeEntity;
import com.capgemini.challenges.abilitytime.DayOfWeek;
import com.capgemini.challenges.abilitytime.TimeOfDay;
import com.capgemini.challenges.abilitytime.service.AbilityTimeService;
import com.capgemini.challenges.game.GameEntity;
import com.capgemini.challenges.player.dao.PlayerDAO;
import com.capgemini.challenges.player.dto.PlayerDTO;
import com.capgemini.challenges.player.mapper.PlayerMapper;
import com.capgemini.challenges.player.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoTest {

    @Mock
    private PlayerDAO playerDAO;

    @Mock
    private PlayerMapper playerMapper;

    @Mock
    private AbilityTimeService abilityTimeService;

    @InjectMocks
    private PlayerService playerService;

    @Before
    public void setup() {
        PlayerDTO player = new PlayerDTO();
        List<GameEntity> games = new ArrayList<>();
        games.add(new GameEntity("Star Wars"));
        player.setListOfOwnedGames(games);
        List<PlayerDTO> players = new ArrayList<>();
        players.add(player);
        players.add(player);

        when(playerService.searchPlayerByUsername(Mockito.anyString())).thenReturn(players);
        when(playerService.searchPlayerByOwnedGames(Mockito.anyString())).thenReturn(players);

        AbilityTimeEntity abilityTimeEntity = new AbilityTimeEntity(DayOfWeek.SUNDAY, TimeOfDay.MORNING);
        when(playerService.searchPlayerByAbilityTime(abilityTimeEntity)).thenReturn(players);
    }

    @Test
    public void shouldAssertEqualsBecauseMockedSizeTwo() {
        //given

        //when
        List<PlayerDTO> newPlayers = playerService.searchPlayerByUsername("Janusz");

        //then
        assertThat(newPlayers.size()).isEqualTo(2);
    }

    @Test
    public void shouldAssertEqualsBecauseMockedNameOfGame() {
        //given

        //when
        List<PlayerDTO> newPlayers = playerService.searchPlayerByOwnedGames("SuperChess");

        //then
        assertThat(newPlayers.get(0).getListOfOwnedGames().get(0).equals("Star Wars"));
        assertThat(newPlayers.size()).isEqualTo(2);
    }

    @Test
    public void shouldAssrtEqualsBecauseMockedAbilityTime(){
        //given
        AbilityTimeEntity abilityTimeEntity = new AbilityTimeEntity(DayOfWeek.SUNDAY, TimeOfDay.MORNING);

        //when
        List<PlayerDTO> newPlayers = playerService.searchPlayerByAbilityTime(abilityTimeEntity);

        //then
        assertThat(newPlayers.size()).isEqualTo(2);
    }
}
