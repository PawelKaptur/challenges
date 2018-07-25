package com.capgemini.challenges.challengeParticipation.service;


import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challengeParticipation.ChallengeParticipationEntity;
import com.capgemini.challenges.challengeParticipation.dao.ChallengeParticipationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeParticipationService {

    private ChallengeParticipationDAO challengeParticipationDAO;

    @Autowired
    public ChallengeParticipationService(ChallengeParticipationDAO challengeParticipationDAO) {
        this.challengeParticipationDAO = challengeParticipationDAO;
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

    //te metody  w challengeParticipation, trzeba dodac komentarz
    public void acceptChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        //ChallengeParticipationEntity challengeParticipation = challengeParticipationDAO.findChallengeParticipationById(challengeParticipationId);
        challengeParticipation.setUserStatus(UserStatus.ACCEPTED);
        challengeParticipation.setComment(comment);
    }

    public void declineChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        //ChallengeParticipationEntity challengeParticipation = challengeParticipationDAO.findChallengeParticipationById(challengeParticipationId);
        challengeParticipation.setUserStatus(UserStatus.DECLINED);
        challengeParticipation.setComment(comment);
        //checkingDeclined(challenge);
    }

    public void modifyStatus(long challengeParticipationId, UserStatus userStatus, String comment) {
        //ChallengeEntity challenge = challengeDAO.findChallengeById(challengeId);
        ChallengeParticipationEntity challengeParticipation = challengeParticipationDAO.findChallengeParticipationById(challengeParticipationId);

        if (userStatus.equals(UserStatus.ACCEPTED)) {
            acceptChallenge(challengeParticipation, comment);
        } else {
            declineChallenge(challengeParticipation, comment);
        }
    }

    public List<ChallengeParticipationEntity> findAllChallengeParticipations(){
        return challengeParticipationDAO.findAllChallengeParticipations();
    }
}
