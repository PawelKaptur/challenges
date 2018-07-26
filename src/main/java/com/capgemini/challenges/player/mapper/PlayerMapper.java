package com.capgemini.challenges.player.mapper;

import com.capgemini.challenges.player.PlayerEntity;
import com.capgemini.challenges.player.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    public PlayerDTO convertToDTO(PlayerEntity player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayerId(player.getPlayerId());
        playerDTO.setUsername(player.getUsername());
        playerDTO.setScore(player.getScore());
        playerDTO.setListOfOwnedGames(player.getListOfOwnedGames());

        return playerDTO;
    }

    public List<PlayerDTO> convertListToDTOList(List<PlayerEntity> players){
        return players.stream().map(c -> convertToDTO(c)).collect(Collectors.toList());
    }
}
