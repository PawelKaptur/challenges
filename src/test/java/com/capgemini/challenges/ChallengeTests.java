package com.capgemini.challenges;

import com.capgemini.challenges.challenge.Challenge;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challenge.service.ChallengeService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ChallengeTests {

    ChallengeDAO challengeDAO = new ChallengeDAO();
    ChallengeService challengeService = new ChallengeService(challengeDAO);
    @Test
    public void shouldAssertEqualBecauseAddedChallenge(){
        //given

        //when
        challengeService.createChallenge(10, 10, 12);

        //then
        assertThat(challengeDAO.getChallenges().size()).isEqualTo(6);
    }

    @Test
    public void shouldAssertEqualBecauseAddedIdshouldBeBiggerByOne(){
        //given

        //when
        challengeService.createChallenge(10, 10, 12);
        long challengeId = challengeDAO.getChallenges().get(challengeDAO.getChallenges().size() - 1).getChallengeId();
        long challengeId2 = challengeDAO.getChallenges().get(challengeDAO.getChallenges().size() - 2).getChallengeId();

        //then
        assertThat(challengeId).isEqualTo(challengeId2 + 1);
    }

    @Test
    public void shouldAssertEqualBecauseRemovedChallenge(){
        //given

        //when
        challengeService.declineChallenge(challengeDAO.getChallenges().get(0).getChallengeId());

        //then
        assertThat(challengeDAO.getChallenges().size()).isEqualTo(4);
    }

}
