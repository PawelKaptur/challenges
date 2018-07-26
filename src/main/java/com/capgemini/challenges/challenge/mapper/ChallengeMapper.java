package com.capgemini.challenges.challenge.mapper;

import com.capgemini.challenges.challenge.ChallengeEntity;
import com.capgemini.challenges.challenge.dto.ChallengeDTO;
import org.springframework.stereotype.Component;

@Component
public class ChallengeMapper {

    public ChallengeDTO convertToDTO(ChallengeEntity challenge){
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setChallengeId(challenge.getChallengeId());
        challengeDTO.setThrownBy(challenge.getThrownBy());
        challengeDTO.setGameId(challenge.getGameId());
        challengeDTO.setChallengeStatus(challenge.isChallengeStatus());
        challengeDTO.setDateOfChallenge(challenge.getDateOfChallenge());
        challengeDTO.setInvitationMessage(challenge.getInvitationMessage());

        return challengeDTO;
    }
}
