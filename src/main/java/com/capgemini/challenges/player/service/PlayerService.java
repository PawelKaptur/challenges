package com.capgemini.challenges.player.service;

import com.capgemini.challenges.player.PlayerEntity;
import com.capgemini.challenges.player.dao.PlayerDAO;
import com.capgemini.challenges.player.dto.PlayerDTO;
import com.capgemini.challenges.player.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlayerService {

    private PlayerDAO playerDAO;
    private PlayerMapper playerMapper;

    @Autowired
    public PlayerService(PlayerDAO playerDAO, PlayerMapper playerMapper) {
        this.playerDAO = playerDAO;
        this.playerMapper = playerMapper;
    }

    public PlayerDTO findPlayer(long playerId) {
        return playerMapper.convertToDTO(playerDAO.findPlayerById(playerId));
    }

    public void addPoints(long playerId, int points) {
        PlayerEntity player = playerDAO.findPlayerById(playerId);
        player.setScore(player.getScore() + points);
    }

    public List<PlayerDTO> searchPlayerByUsername(String username) {
        List<PlayerEntity> players = playerDAO.findAllPlayers();
        Stream<PlayerEntity> stream = players.stream();
        List<PlayerEntity> foundPlayers = stream.filter(p -> p.getUsername().equals(username)).collect(Collectors.toList());

        return playerMapper.convertListToDTOList(foundPlayers);
    }

    public List<PlayerDTO> searchPlayerByOwnedGames(String gameName) {
        List<PlayerEntity> players = playerDAO.findAllPlayers();
        List<PlayerEntity> foundPlayers = new ArrayList<>();
        for (PlayerEntity player : players) {
            for (int i = 0; i < player.getListOfOwnedGames().size(); i++) {
                if (player.getListOfOwnedGames().get(i).getName().equals(gameName)) {
                    foundPlayers.add(player);
                }
            }
        }

        return playerMapper.convertListToDTOList(foundPlayers);
    }
}
