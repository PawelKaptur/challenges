package com.capgemini.challenges;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challenge.service.ChallengeService;
import org.junit.After;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        Map<Long, UserStatus> userDecision = new TreeMap<>();
        userDecision.put(6L, UserStatus.UNDECIDED);
        userDecision.put(7L, UserStatus.UNDECIDED);

        //when
        challengeService.createChallenge(10, userDecision);

        //then
        assertThat(challengeDAO.findAllChallenges().size()).isEqualTo(7);
    }

    @Test
    public void shouldAssertEqualBecauseAddedIdshouldBeBiggerByOne(){
        //given
        Map<Long, UserStatus> userDecision = new TreeMap<>();
        userDecision.put(6L, UserStatus.UNDECIDED);
        userDecision.put(7L, UserStatus.UNDECIDED);

        //when
        challengeService.createChallenge(10, userDecision);
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
    public void shouldAssertEqualBecausePlayerDeclined(){
        //given

        //when
        challengeService.modifyStatuses(4L,1, UserStatus.DECLINED);

        //then
        assertThat(challengeDAO.findChallengeById(1).getUserDecision().get(4L)).isEqualTo(UserStatus.DECLINED);
        assertThat(challengeDAO.findChallengeById(2).getUserDecision().get(4L)).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeDAO.findChallengeById(3).getUserDecision().get(4L)).isEqualTo(UserStatus.UNDECIDED);
    }

    @Test
    public void shouldAssertEqualBecauseEveryoneDeclined(){
        //given

        //when
        challengeService.modifyStatuses(2L,3, UserStatus.DECLINED);
        challengeService.modifyStatuses(0L,3, UserStatus.DECLINED);
        challengeService.modifyStatuses(4L,3, UserStatus.DECLINED);

        //then
        assertThat(challengeDAO.findAllChallenges().size()).isEqualTo(5);
    }

    @Test
    public void shouldAssertEqualBecausePlayerAccepted(){
        //given

        //when
        challengeService.modifyStatuses(0L,3, UserStatus.ACCEPTED);

        //then
        assertThat(challengeDAO.findChallengeById(0).getUserDecision().get(0L)).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeDAO.findChallengeById(3).getUserDecision().get(0L)).isEqualTo(UserStatus.ACCEPTED);
    }

    @Test
    public void shouldAssertEqualBecauseNoOneAccepted(){
        //given

        //when

        //then
        assertThat(challengeDAO.findChallengeById(1).getUserDecision().get(2L)).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeDAO.findChallengeById(1).getUserDecision().get(1L)).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeDAO.findChallengeById(1).getUserDecision().get(4L)).isEqualTo(UserStatus.UNDECIDED);
    }

    @Test
    public void shouldAssertEqualBecausePlayerAcceptedOneChallenge(){
        //given

        //when
        challengeService.modifyStatuses(0L,0L, UserStatus.ACCEPTED);
        System.out.println(challengeDAO.findChallengeById(0).getUserDecision());
        List<Challenge> challenges = challengeService.showAcceptedChallenges(0);
        //then

        assertThat(challenges.size()).isEqualTo(1);
    }

    @Test
    public void shouldAssertEqualBecauseSystemCreatedOneChallenge(){
        //given

        //when
        List<Challenge> systemChallenges = challengeService.showChallengesCreatedBySystem();
        //then

        assertThat(systemChallenges.size()).isEqualTo(2);
    }

    @Test
    public void shouldAssertEqualBecauseForThrownChallengesByUsers(){
        //given

        //when
        List<Challenge> systemChallenges0 = challengeService.showChallengesThrownBy(0);
        List<Challenge> systemChallenges2 = challengeService.showChallengesThrownBy(2);
        List<Challenge> systemChallenges3 = challengeService.showChallengesThrownBy(3);
        List<Challenge> systemChallenges4 = challengeService.showChallengesThrownBy(4);
        //then

        assertThat(systemChallenges0.size()).isEqualTo(1);
        assertThat(systemChallenges2.size()).isEqualTo(2);
        assertThat(systemChallenges3.size()).isEqualTo(0);
        assertThat(systemChallenges4.size()).isNotEqualTo(0);
    }
}
