package com.capgemini.challenges;

import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challenge.dto.ChallengeDTO;
import com.capgemini.challenges.challenge.service.ChallengeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ChallengeService challengeServiceMock;

    @Mock
    private ChallengeDAO challengeDAO;

    @Before
    public void setUp() {
        challengeDAO = new ChallengeDAO();
    }

    @Test
    public void testShowChallengesThrownAt() throws Exception {
        //given
        String url = "/challengethrownat/1000";
        long id = 1000;
        List<ChallengeDTO> challenges = new ArrayList<>();
        ChallengeDTO challengeDTO = new ChallengeDTO();
        String message = "I will crush you";
        challengeDTO.setInvitationMessage(message);
        challenges.add(challengeDTO);
        challenges.add(new ChallengeDTO());

        //when
        when(challengeServiceMock.showChallengesThrownAt(id)).thenReturn(challenges);
        ResultActions actions = mockMvc.perform(get(url));

        //then
        actions.andExpect(status().isOk());
    }

    @Test
    public void shouldCreateChallenge() throws Exception {

        //when
        ResultActions actions = mockMvc.perform(post("/create").param("playerId", "1").param("gameId", "1").param("comment", "asd").param("date", "200000000000").param("args", "1", "2", "3"));

        //then
        actions.andExpect(status().isOk())
                .andExpect(content().string(containsString("Challenge created")));

    }

    @Test
    public void findChallengeByAllParameters() throws Exception {

        //when
        ResultActions actions = mockMvc.perform(post("/challenge/find").param("thrownBy", "1").param("end", "false").param("message", "hi"));

        //then
        actions.andExpect(status().isOk());
    }

    @Test
    public void findChallengeByMessage() throws Exception {

        //when
        ResultActions actions = mockMvc.perform(post("/challenge/find").param("message", "hihihi"));

        //then
        actions.andExpect(status().isOk());
    }

}
