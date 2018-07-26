package com.capgemini.challenges.challengeparticipation.mapper;

import com.capgemini.challenges.challengeparticipation.ChallengeParticipationEntity;
import com.capgemini.challenges.challengeparticipation.dto.ChallengeParticipationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChallengeParticipationMapper {

    public ChallengeParticipationDTO convertToDTO(ChallengeParticipationEntity participation) {
        ChallengeParticipationDTO participationDTO = new ChallengeParticipationDTO();
        participationDTO.setChallengeParticipationId(participation.getChallengeId());
        participationDTO.setUserId(participation.getUserId());
        participationDTO.setChallengeId(participation.getChallengeId());
        participationDTO.setUserStatus(participation.getUserStatus());
        participationDTO.setComment(participation.getComment());

        return participationDTO;
    }

    public List<ChallengeParticipationDTO> convertListToDTOList(List<ChallengeParticipationEntity> participations) {
        return participations.stream().map(c -> convertToDTO(c)).collect(Collectors.toList());
    }
}
