package com.capgemini.challenges;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challenge.service.ChallengeService;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChallengeTests {

    ChallengeDAO challengeDAO = new ChallengeDAO();
    ChallengeService challengeService = new ChallengeService(challengeDAO);

    @After
    public void emptyList(){
        ChallengeDAO.setIdCounter(0);
    }

    @Test
    public void shouldAssertEqualBecauseAddedChallenge(){
        //given
        List<Long> playersId = new ArrayList<>();
        playersId.add(6L);
        playersId.add(7L);

        //when
        challengeService.createChallenge(10, playersId);

        //then
        assertThat(challengeDAO.findAllChallenges().size()).isEqualTo(6);
    }

    @Test
    public void shouldAssertEqualBecauseAddedIdshouldBeBiggerByOne(){
        //given
        List<Long> playersId = new ArrayList<>();
        playersId.add(6L);
        playersId.add(7L);

        //when
        challengeService.createChallenge(10, playersId);
        long challengeId = challengeDAO.findAllChallenges().get(challengeDAO.findAllChallenges().size() - 1).getChallengeId();
        long challengeId2 = challengeDAO.findAllChallenges().get(challengeDAO.findAllChallenges().size() - 2).getChallengeId();

        //then
        assertThat(challengeId).isEqualTo(challengeId2 + 1);
    }

    @Test
    public void shouldFindChallengeById(){
        //given

        //when
        Challenge challenge = challengeDAO.findChallengeById(3L);
        //then

        assertThat(challenge.getChallengeId()).isEqualTo(3L);
    }

    @Test
    public void shouldAssertEqualBecauseEveryoneDeclined(){
        //given

        //when
        challengeService.modifyStatuses(0L,2, UserStatus.DECLINED);
        challengeService.modifyStatuses(1L,2, UserStatus.DECLINED);
        challengeService.modifyStatuses(2L,2, UserStatus.DECLINED);

        //then
        assertThat(challengeDAO.findAllChallenges().size()).isEqualTo(4);
    }

    @Test
    public void shouldAssertEqualBecausePlayerAccepted(){
        //given

        //when
        challengeService.modifyStatuses(0L,2, UserStatus.ACCEPTED);

        //then
        assertThat(challengeDAO.findChallengeById(2).getStatusesOfPlayers().get(0)).isEqualTo(UserStatus.ACCEPTED);
    }

    @Test
    public void shouldAssertEqualBecauseNoOneAccepted(){
        //given

        //when

        //then
        assertThat(challengeDAO.findChallengeById(2).getStatusesOfPlayers().get(0)).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeDAO.findChallengeById(2).getStatusesOfPlayers().get(1)).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeDAO.findChallengeById(2).getStatusesOfPlayers().get(2)).isEqualTo(UserStatus.UNDECIDED);
    }

}
