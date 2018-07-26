package com.capgemini.challenges;

import com.capgemini.challenges.challenge.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengesApplication implements ApplicationRunner {

    @Autowired
    private ChallengeService challengeService;

    public static void main(String[] args) {
        SpringApplication.run(ChallengesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(challengeService.showChallengesThrownBy(1));
    }
}
