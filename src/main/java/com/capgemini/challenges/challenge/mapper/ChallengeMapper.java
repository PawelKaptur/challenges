package com.capgemini.challenges.challenge.mapper;

import com.capgemini.challenges.challenge.ChallengeEntity;
import com.capgemini.challenges.challenge.dto.ChallengeDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChallengeMapper {

    public ChallengeDTO convertToDTO(ChallengeEntity challenge) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setChallengeId(challenge.getChallengeId());
        challengeDTO.setThrownBy(challenge.getThrownBy());
        challengeDTO.setGameId(challenge.getGameId());
        challengeDTO.setChallengeStatus(challenge.isGameIsEnd());
        challengeDTO.setDateOfChallenge(challenge.getDateOfChallenge());
        challengeDTO.setInvitationMessage(challenge.getInvitationMessage());

        return challengeDTO;
    }

    public List<ChallengeDTO> convertListToDTOList(List<ChallengeEntity> challenges) {
        return challenges.stream().map(c -> convertToDTO(c)).collect(Collectors.toList());
    }
}
