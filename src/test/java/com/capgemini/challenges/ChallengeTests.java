package com.capgemini.challenges;

import com.capgemini.challenges.challenge.ChallengeEntity;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challenge.dto.ChallengeDTO;
import com.capgemini.challenges.challenge.mapper.ChallengeMapper;
import com.capgemini.challenges.challenge.service.ChallengeService;
import com.capgemini.challenges.challengeparticipation.dao.ChallengeParticipationDAO;
import com.capgemini.challenges.challengeparticipation.mapper.ChallengeParticipationMapper;
import com.capgemini.challenges.challengeparticipation.service.ChallengeParticipationService;
import com.capgemini.challenges.player.dao.PlayerDAO;
import com.capgemini.challenges.player.dto.PlayerDTO;
import com.capgemini.challenges.player.mapper.PlayerMapper;
import com.capgemini.challenges.player.service.PlayerService;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChallengeTests {

    ChallengeDAO challengeDAO = new ChallengeDAO();
    PlayerDAO playerDAO = new PlayerDAO();
    PlayerMapper playerMapper = new PlayerMapper();
    PlayerService playerService = new PlayerService(playerDAO, playerMapper);
    ChallengeParticipationDAO challengeParticipationDAO = new ChallengeParticipationDAO();
    ChallengeParticipationMapper challengeParticipationMapper = new ChallengeParticipationMapper();
    ChallengeParticipationService challengeParticipationService = new ChallengeParticipationService(challengeParticipationDAO, challengeParticipationMapper);
    ChallengeMapper challengeMapper = new ChallengeMapper();
    ChallengeService challengeService = new ChallengeService(challengeDAO, playerService, challengeParticipationService, challengeMapper);

    @After
    public void emptyList(){
        ChallengeDAO.setIdCounter(0);
        PlayerDAO.setIdCounter(0);
        ChallengeParticipationDAO.setIdCounter(0);
    }

    @Test
    public void shouldAssertEqualBecauseAddedChallenge(){
        //given
        List<Long> playersId = new ArrayList<>();
        playersId.add(1L);
        playersId.add(2L);
        playersId.add(3L);
        String message = "Lets dance";

        //when
        challengeService.createChallenge(10, 10, playersId, message);

        //then
        assertThat(challengeDAO.findAllChallenges().size()).isEqualTo(7);
    }

    @Test
    public void shouldAssertEqualBecauseAddedIdShouldBeBiggerByOne(){
        //given
        List<Long> playersId = new ArrayList<>();
        playersId.add(1L);
        playersId.add(2L);
        playersId.add(3L);
        String message = "Lets dance";

        //when
        challengeService.createChallenge(10, 10, playersId, message);
        long challengeId = challengeDAO.findAllChallenges().get(challengeDAO.findAllChallenges().size() - 1).getChallengeId();
        long challengeId2 = challengeDAO.findAllChallenges().get(challengeDAO.findAllChallenges().size() - 2).getChallengeId();

        //then
        assertThat(challengeId).isEqualTo(challengeId2 + 1);
    }

    @Test
    public void shouldFindChallengeById(){
        //given

        //when
        ChallengeEntity challenge = challengeDAO.findChallengeById(3L);

        //then
        assertThat(challenge.getChallengeId()).isEqualTo(3L);
    }

    @Test
    public void shouldAssertEqualBecausePlayerDeclined(){
        //given

        //when
        String comment = "I cant";
        challengeParticipationService.modifyStatus(5L,UserStatus.DECLINED, comment);

        //then
        assertThat(challengeParticipationDAO.findChallengeParticipationById(5).getUserStatus()).isEqualTo(UserStatus.DECLINED);
        assertThat(challengeParticipationDAO.findChallengeParticipationById(6).getUserStatus()).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeParticipationDAO.findChallengeParticipationById(7).getUserStatus()).isEqualTo(UserStatus.UNDECIDED);
    }

    @Test
    public void shouldAssertEqualBecausePlayerAccepted(){
        //given

        //when
        String comment = "Bring it on";
        challengeParticipationService.modifyStatus(2L,UserStatus.ACCEPTED,  comment);

        //then
        assertThat(challengeParticipationDAO.findChallengeParticipationById(8).getUserStatus()).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeParticipationDAO.findChallengeParticipationById(2).getUserStatus()).isEqualTo(UserStatus.ACCEPTED);
    }

    @Test
    public void shouldAssertEqualBecauseNoOneAccepted(){
        //given

        //when

        //then
        assertThat(challengeParticipationDAO.findChallengeParticipationById(1).getUserStatus()).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeParticipationDAO.findChallengeParticipationById(5).getUserStatus()).isEqualTo(UserStatus.UNDECIDED);
        assertThat(challengeParticipationDAO.findChallengeParticipationById(9).getUserStatus()).isEqualTo(UserStatus.UNDECIDED);
    }

    @Test
    public void shouldAssertEqualBecausePlayerAcceptedOneChallenge(){
        //given
        String comment = "I accept your challenge";

        //when
        challengeParticipationService.modifyStatus(2L,UserStatus.ACCEPTED,  comment);
        List<ChallengeDTO> challenges = challengeService.showAcceptedChallenges(0);

        //then
        assertThat(challenges.size()).isEqualTo(1);
    }

    @Test
    public void shouldAssertEqualBecauseSystemCreatedTwoChallenges(){
        //given

        //when
        List<ChallengeDTO> systemChallenges = challengeService.showChallengesCreatedBySystem();

        //then
        assertThat(systemChallenges.size()).isEqualTo(2);
    }

    @Test
    public void shouldAssertEqualForThrownChallengesByUsers(){
        //given

        //when
        List<ChallengeDTO> systemChallenges0 = challengeService.showChallengesThrownBy(0);
        List<ChallengeDTO> systemChallenges2 = challengeService.showChallengesThrownBy(2);
        List<ChallengeDTO> systemChallenges3 = challengeService.showChallengesThrownBy(3);
        List<ChallengeDTO> systemChallenges4 = challengeService.showChallengesThrownBy(4);

        //then
        assertThat(systemChallenges0.size()).isEqualTo(1);
        assertThat(systemChallenges2.size()).isEqualTo(2);
        assertThat(systemChallenges3.size()).isEqualTo(0);
        assertThat(systemChallenges4.size()).isNotEqualTo(0);
    }

    @Test
    public void shouldAssertForChallengesThrownAtUsers(){
        //given

        //when
        List<ChallengeDTO> systemChallenges2 = challengeService.showChallengesThrownAt(2);
        List<ChallengeDTO> systemChallenges3 = challengeService.showChallengesThrownAt(3);

        //then
        assertThat(systemChallenges2.size()).isEqualTo(1);
        assertThat(systemChallenges3.size()).isEqualTo(0);
    }

    @Test
    public void shouldBeEqualBecauseTwoPlayersInChallenge(){
        //given

        //when
        List<PlayerDTO> players = challengeService.showOpponentsInfoBySelectingChallenge(2);

        //then
        assertThat(players.size()).isEqualTo(2);
    }

    @Test
    public void shouldAssertEqualBecausePlayerOneWon(){
        //given

        //when
        challengeService.endOfChallenge(1,1);

        //then
        assertThat(playerService.findPlayer(1).getScore()).isEqualTo(10);
        assertThat(playerService.findPlayer(2).getScore()).isEqualTo(0);
        assertThat(playerService.findPlayer(0).getScore()).isEqualTo(0);
        assertThat(playerService.findPlayer(4).getScore()).isEqualTo(0);
        assertThat(challengeDAO.findChallengeById(1).isChallengeStatus()).isTrue();
        assertThat(challengeDAO.findChallengeById(0).isChallengeStatus()).isFalse();
    }

}
