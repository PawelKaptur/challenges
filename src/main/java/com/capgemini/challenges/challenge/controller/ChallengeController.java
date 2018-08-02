package com.capgemini.challenges.challenge.controller;

import com.capgemini.challenges.challenge.dto.ChallengeDTO;
import com.capgemini.challenges.challenge.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ResponseBody
@Controller
public class ChallengeController {

    ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challengethrownat/{id}")
    public List<ChallengeDTO> showChallengesThrownAt(@PathVariable("id") long playerId) {
        return challengeService.showChallengesThrownAt(playerId);
    }

    @PostMapping("/create")
    public String createChallenge(@RequestParam("playerId") long playerId,@RequestParam("gameId") long gameId, @RequestParam("comment") String comment, @RequestParam("date") long dateOfChallenge, @RequestParam("args") long... args) {
        List<Long> playersId = new ArrayList<>();
        for (long arg : args) {
            playersId.add(arg);
        }

        challengeService.createChallenge(playerId, gameId, playersId, comment, dateOfChallenge);
        return "Challenge created";
    }

    @PostMapping("/challenge/find")
    public List<ChallengeDTO> findChallenge(@RequestParam(value = "thrownBy", required = false) Long thrownBy,
                                            @RequestParam(value = "end", required = false) Boolean isGameIsEnd,
                                            @RequestParam(value = "message", required = false) String message) {
        ChallengeDTO challengeDTO = new ChallengeDTO();

        challengeDTO.setThrownBy(thrownBy);
        challengeDTO.setGameIsEnd(isGameIsEnd);
        challengeDTO.setInvitationMessage(message);

        List<ChallengeDTO> challenges = challengeService.findChallengesByParams(challengeDTO);
        return challenges;
    }
}
