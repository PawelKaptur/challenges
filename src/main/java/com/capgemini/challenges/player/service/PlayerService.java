package com.capgemini.challenges.player.service;

import com.capgemini.challenges.abilitytime.AbilityTimeEntity;
import com.capgemini.challenges.abilitytime.service.AbilityTimeService;
import com.capgemini.challenges.player.PlayerEntity;
import com.capgemini.challenges.player.dao.PlayerDAO;
import com.capgemini.challenges.player.dto.PlayerDTO;
import com.capgemini.challenges.player.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private PlayerDAO playerDAO;
    private PlayerMapper playerMapper;
    private AbilityTimeService abilityTimeService;

    @Autowired
    public PlayerService(PlayerDAO playerDAO, PlayerMapper playerMapper, AbilityTimeService abilityTimeService) {
        this.playerDAO = playerDAO;
        this.playerMapper = playerMapper;
        this.abilityTimeService = abilityTimeService;
    }

    public PlayerDTO findPlayer(long playerId) {
        return playerMapper.convertToDTO(playerDAO.findPlayerById(playerId));
    }

    public void addPoints(long playerId, int points) {
        PlayerEntity player = playerDAO.findPlayerById(playerId);
        player.setScore(player.getScore() + points);
    }

    public List<PlayerDTO> searchPlayerByUsername(String username) {
        return playerMapper.convertListToDTOList(playerDAO.findPlayersByUsername(username));
    }

    public List<PlayerDTO> searchPlayerByOwnedGames(String gameName) {
        return playerMapper.convertListToDTOList(playerDAO.findPlayersByOwnedGames(gameName));
    }

    public List<PlayerDTO> searchPlayerByAbilityTime(AbilityTimeEntity abilityTime) {
        List<Long> playersId = abilityTimeService.findPlayersIdByAbilityTime(abilityTime);
        List<PlayerEntity> foundPlayers = new ArrayList<>();
        for (Long playerId : playersId) {
            foundPlayers.add(playerDAO.findPlayerById(playerId));
        }

        return playerMapper.convertListToDTOList(foundPlayers);
    }
}
