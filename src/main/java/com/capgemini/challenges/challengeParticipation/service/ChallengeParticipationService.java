package com.capgemini.challenges.challengeParticipation.service;


import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challengeParticipation.ChallengeParticipationEntity;
import com.capgemini.challenges.challengeParticipation.dao.ChallengeParticipationDAO;
import com.capgemini.challenges.challengeParticipation.dto.ChallengeParticipationDTO;
import com.capgemini.challenges.challengeParticipation.mapper.ChallengeParticipationMapper;
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

    public void createChallengeParticipation(long challengeId, long playersId) {
        ChallengeParticipationEntity challengeParticipation = new ChallengeParticipationEntity();
        challengeParticipation.setChallengeId(challengeId);
        challengeParticipation.setUserId(playersId);

        challengeParticipationDAO.addChallengeParticipation(challengeParticipation);
    }

    public void createChallengeParticipations(long challengeId, List<Long> playersId) {
        for (int i = 0; i < playersId.size(); i++) {
            createChallengeParticipation(challengeId, playersId.get(i));
        }
    }

    public void acceptChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        challengeParticipation.setUserStatus(UserStatus.ACCEPTED);
        challengeParticipation.setComment(comment);
    }

    public void declineChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        challengeParticipation.setUserStatus(UserStatus.DECLINED);
        challengeParticipation.setComment(comment);
    }

    public void modifyStatus(long challengeParticipationId, UserStatus userStatus, String comment) {
        ChallengeParticipationEntity challengeParticipation = challengeParticipationDAO.findChallengeParticipationById(challengeParticipationId);

        if (userStatus.equals(UserStatus.ACCEPTED)) {
            acceptChallenge(challengeParticipation, comment);
        } else {
            declineChallenge(challengeParticipation, comment);
        }
    }

   // public List<ChallengeParticipationEntity> findAllChallengeParticipations(){
     //   return challengeParticipationDAO.findAllChallengeParticipations();
   // }

    public List<ChallengeParticipationDTO> findAllChallengeParticipations(){
        return mapper.convertListToDTOList(challengeParticipationDAO.findAllChallengeParticipations());
    }
}
