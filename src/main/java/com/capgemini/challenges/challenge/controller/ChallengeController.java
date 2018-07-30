package com.capgemini.challenges.challenge.controller;

import com.capgemini.challenges.challenge.dto.ChallengeDTO;
import com.capgemini.challenges.challenge.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<ChallengeDTO> showChallengesThrownAt(@ModelAttribute("id") long playerId){
        return challengeService.showChallengesThrownAt(playerId);
    }

    @PostMapping("/create")
    public String createChallenge(long playerId, long gameId, String comment, long dateOfChallenge, long... args){
        List<Long> playersId = new ArrayList<>();
        for (long arg: args){
            playersId.add(arg);
        }

        challengeService.createChallenge(playerId, gameId, playersId, comment,dateOfChallenge);
        return "Challenge created";
    }

    @GetMapping("challenge/")
    public List<ChallengeDTO> findChallenge(){

        return null;
    }
}
