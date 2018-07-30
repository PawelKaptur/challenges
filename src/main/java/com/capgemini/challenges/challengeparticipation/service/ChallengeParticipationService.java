package com.capgemini.challenges.challengeparticipation.service;


import com.capgemini.challenges.challengeparticipation.ChallengeParticipationEntity;
import com.capgemini.challenges.challengeparticipation.UserStatus;
import com.capgemini.challenges.challengeparticipation.dao.ChallengeParticipationDAO;
import com.capgemini.challenges.challengeparticipation.dto.ChallengeParticipationDTO;
import com.capgemini.challenges.challengeparticipation.mapper.ChallengeParticipationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeParticipationService {

    private ChallengeParticipationDAO challengeParticipationDAO;
    private ChallengeParticipationMapper mapper;

    @Autowired
    public ChallengeParticipationService(ChallengeParticipationDAO challengeParticipationDAO, ChallengeParticipationMapper challengeParticipationMapper) {
        this.challengeParticipationDAO = challengeParticipationDAO;
        this.mapper = challengeParticipationMapper;
    }

    public void createChallengeParticipations(long challengeId, List<Long> playersId) {
        for (Long playerId : playersId) {
            createChallengeParticipation(challengeId, playerId);
        }
    }

    private void createChallengeParticipation(long challengeId, long playersId) {
        ChallengeParticipationEntity challengeParticipation = new ChallengeParticipationEntity();
        challengeParticipation.setChallengeId(challengeId);
        challengeParticipation.setUserId(playersId);

        challengeParticipationDAO.addChallengeParticipation(challengeParticipation);
    }

    public void acceptChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        challengeParticipation.setUserStatus(UserStatus.ACCEPTED);
        challengeParticipation.setComment(comment);
    }

    public void declineChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        challengeParticipation.setUserStatus(UserStatus.DECLINED);
        challengeParticipation.setComment(comment);
    }

    /*
    method that finds challenge by challengeId and according to userStatus it choose which method it
    should use acceptChallenge or declineChallenge
    */
    public void modifyStatus(long challengeParticipationId, UserStatus userStatus, String comment) {
        ChallengeParticipationEntity challengeParticipation = challengeParticipationDAO.findChallengeParticipationById(challengeParticipationId);

        if (userStatus.equals(UserStatus.ACCEPTED)) {
            acceptChallenge(challengeParticipation, comment);
        } else {
            declineChallenge(challengeParticipation, comment);
        }
    }

    public List<ChallengeParticipationDTO> findAllChallengesByPlayer(long playerId) {
        return mapper.convertListToDTOList(challengeParticipationDAO.findAllChallengeParticipationsByPlayer(playerId));
    }

    public List<ChallengeParticipationDTO> findAllChallengesAcceptedByPlayer(long playerId) {
        return mapper.convertListToDTOList(challengeParticipationDAO.findAllChallengesAcceptedByPlayer(playerId));
    }

    public List<Long> findOpponentsInChallenge(long challengeId) {
        return challengeParticipationDAO.findOpponentsInChallenge(challengeId);
    }
}
