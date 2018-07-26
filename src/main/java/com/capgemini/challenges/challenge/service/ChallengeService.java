package com.capgemini.challenges.challenge.service;

import com.capgemini.challenges.challenge.ChallengeEntity;
import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challenge.dto.ChallengeDTO;
import com.capgemini.challenges.challenge.mapper.ChallengeMapper;
import com.capgemini.challenges.challengeParticipation.ChallengeParticipationEntity;
import com.capgemini.challenges.challengeParticipation.service.ChallengeParticipationService;
import com.capgemini.challenges.player.PlayerEntity;
import com.capgemini.challenges.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChallengeService {
    private final static long SYSTEM_ID = -1;
    private ChallengeDAO challengeDAO;
    private PlayerService playerService;
    private ChallengeParticipationService challengeParticipationService;
    private ChallengeMapper challengeMapper;

    public ChallengeService(ChallengeDAO challengeDAO, PlayerService playerService, ChallengeParticipationService challengeParticipationService, ChallengeMapper challengeMapper) {
        this.challengeDAO = challengeDAO;
        this.playerService = playerService;
        this.challengeParticipationService = challengeParticipationService;
        this.challengeMapper = challengeMapper;
    }

    public void createChallenge(long playerId, long gameId, List<Long> playersId, String message) {
        ChallengeEntity challenge = new ChallengeEntity();
        challenge.setThrownBy(playerId);
        challenge.setGameId(gameId);
        challenge.setDateOfChallenge(new Date());
        challenge.setInvitationMessage(message);
        challenge.setChallengeStatus(false);

        challengeDAO.addChallenge(challenge);
        challengeParticipationService.createChallengeParticipations(challenge.getChallengeId(), playersId);
    }

    public List<ChallengeDTO> showAcceptedChallenges(long playerId) {
        List<ChallengeEntity> challengeList = new ArrayList<>();
        List<ChallengeParticipationEntity> challengeParticipationList = challengeParticipationService.findAllChallengeParticipations();

        for (ChallengeParticipationEntity participation : challengeParticipationList) {
            if (participation.getUserId() == playerId && participation.getUserStatus().equals(UserStatus.ACCEPTED)) {
                challengeList.add(challengeDAO.findChallengeById(participation.getChallengeId()));
            }
        }

        //moze w mapperze metoda do przerzucania calej listy
        List<ChallengeDTO> challengeDTOList = challengeList.stream().map(c -> challengeMapper.convertToDTO(c)).collect(Collectors.toList());

        return challengeDTOList;
    }

    public List<ChallengeEntity> showChallengesCreatedBySystem() {
        return showChallengesThrownBy(SYSTEM_ID);
    }

    public List<ChallengeEntity> showChallengesThrownBy(long playerId) {
        return challengeDAO.findChallengesThrownBy(playerId);
    }


    public List<ChallengeEntity> showChallengesThrownAt(long playerId) {
        List<ChallengeEntity> challengeList = new ArrayList<>();
        List<ChallengeParticipationEntity> challengeParticipationList = challengeParticipationService.findAllChallengeParticipations();

        for (ChallengeParticipationEntity participation : challengeParticipationList) {
            if (participation.getUserId() == playerId && challengeDAO.findChallengeById(participation.getChallengeId()).getThrownBy() != playerId) {
                challengeList.add(challengeDAO.findChallengeById(participation.getChallengeId()));
            }
        }

        return challengeList;
    }

    public List<PlayerEntity> showOpponentsInfoBySelectingChallenge(long challengeId) {
        List<ChallengeParticipationEntity> challengeParticipationList = challengeParticipationService.findAllChallengeParticipations();

        List<Long> playersId = new ArrayList<>();
        for (ChallengeParticipationEntity participation : challengeParticipationList) {
            if (participation.getChallengeId() == challengeId) {
                playersId.add(participation.getUserId());
            }
        }

        List<PlayerEntity> players = new ArrayList<>();

        for (Long id : playersId) {
            PlayerEntity player = playerService.findPlayer(id);
            players.add(player);
        }

        return players;
    }

    public void endOfChallenge(long winnerId, long challengeId) {
        ChallengeEntity challenge = challengeDAO.findChallengeById(challengeId);
        challenge.setChallengeStatus(true);
        int points = 10;
        playerService.addPoints(winnerId, points);
    }

    //zapisywanie informacji o zakonczonej grze, dokonczyc
    public void saveChallenge(long challengeId) {
        ChallengeEntity challenge = challengeDAO.findChallengeById(challengeId);
        if (challenge.isChallengeStatus()) {

        }
    }
}
