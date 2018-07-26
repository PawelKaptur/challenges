package com.capgemini.challenges;

import com.capgemini.challenges.abilitytime.service.AbilityTimeService;
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
        List<PlayerDTO> players = new ArrayList<>();
        players.add(player);
        players.add(player);

        when(playerService.searchPlayerByUsername(Mockito.anyString())).thenReturn(players);
    }

    @Test
    public void shouldAssertEqualsBecauseMockedSizeTwo() {
        //given

        //when
        List<PlayerDTO> newPlayers = playerService.searchPlayerByUsername("Janusz");

        //then
        assertThat(newPlayers.size()).isEqualTo(2);
    }
}
