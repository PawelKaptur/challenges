package com.capgemini.challenges.challengeParticipation.service;


import com.capgemini.challenges.challenge.UserStatus;
import com.capgemini.challenges.challenge.dao.ChallengeDAO;
import com.capgemini.challenges.challengeParticipation.ChallengeParticipationEntity;
import com.capgemini.challenges.challengeParticipation.dao.ChallengeParticipationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeParticipationService {

    private ChallengeParticipationDao challengeParticipationDao;

    @Autowired
    public ChallengeParticipationService(ChallengeParticipationDao challengeParticipationDao) {
        this.challengeParticipationDao = challengeParticipationDao;
    }

    public void createChallengeParticipation(long challengeId, long playersId) {
        ChallengeParticipationEntity challengeParticipation = new ChallengeParticipationEntity();
        challengeParticipation.setChallengeId(challengeId);
        challengeParticipation.setUserId(playersId);

        challengeParticipationDao.addChallengeParticipation(challengeParticipation);
    }

    public void createChallengeParticipations(long challengeId, List<Long> playersId) {
        for (int i = 0; i < playersId.size(); i++) {
            createChallengeParticipation(challengeId, playersId.get(i));
        }
    }

    //te metody  w challengeParticipation, trzeba dodac komentarz
    public void acceptChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        //ChallengeParticipationEntity challengeParticipation = challengeParticipationDao.findChallengeParticipationById(challengeParticipationId);
        challengeParticipation.setUserStatus(UserStatus.ACCEPTED);
        challengeParticipation.setComment(comment);
    }

    public void declineChallenge(ChallengeParticipationEntity challengeParticipation, String comment) {
        //ChallengeParticipationEntity challengeParticipation = challengeParticipationDao.findChallengeParticipationById(challengeParticipationId);
        challengeParticipation.setUserStatus(UserStatus.DECLINED);
        challengeParticipation.setComment(comment);
        //checkingDeclined(challenge);
    }

    public void modifyStatus(long challengeParticipationId, UserStatus userStatus, String comment) {
        //ChallengeEntity challenge = challengeDAO.findChallengeById(challengeId);
        ChallengeParticipationEntity challengeParticipation = challengeParticipationDao.findChallengeParticipationById(challengeParticipationId);

        if (userStatus.equals(UserStatus.ACCEPTED)) {
            acceptChallenge(challengeParticipation, comment);
        } else {
            declineChallenge(challengeParticipation, comment);
        }
    }
}
