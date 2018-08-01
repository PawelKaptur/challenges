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

    @PostMapping("/challenge/find")
    public List<ChallengeDTO> findChallenge(@RequestParam(value = "thrownBy", required = false) Long thrownBy,
                                            @RequestParam(value = "end", required = false) Boolean isGameIsEnd,
                                            @RequestParam(value = "message", required = false) String message){
        ChallengeDTO challengeDTO = new ChallengeDTO();
        if(thrownBy != null){
            challengeDTO.setThrownBy(thrownBy);
        }
        if(isGameIsEnd != null){
            challengeDTO.setGameIsEnd(isGameIsEnd);
        }
        if(message != null){
            challengeDTO.setInvitationMessage(message);
        }

        List<ChallengeDTO> challenges = challengeService.findChallengesByParams(challengeDTO);
        return challenges;
    }

 /*   @ExceptionHandler({NotFound.class})
    public String handleException(Model model) {
        model.addAttribute("error", "Access denied, normal user cannot remove books");
        return "403";
    }*/
}
